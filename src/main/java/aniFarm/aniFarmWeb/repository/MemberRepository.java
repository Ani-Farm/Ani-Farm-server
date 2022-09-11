package aniFarm.aniFarmWeb.repository;

import aniFarm.aniFarmWeb.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
