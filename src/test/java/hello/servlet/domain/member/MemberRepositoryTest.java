package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository =MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        Member member1 =new Member("hello",20);
        Member saveMember = memberRepository.save(member1);
        Member findMember = memberRepository.findById(saveMember.getId());

        assertThat(findMember).isSameAs(saveMember);


    }

    @Test
    void findAll() {
        Member member1 =new Member("hello",20);
        memberRepository.save(member1);
        Member member2 =new Member("hello1",21);
        memberRepository.save(member2);
        Member member3 =new Member("hello2",22);
        memberRepository.save(member3);


        List<Member> members = memberRepository.findAll();

        assertThat(members.size()).isEqualTo(3);
        assertThat(members).contains(member1,member2,member3);

    }


}