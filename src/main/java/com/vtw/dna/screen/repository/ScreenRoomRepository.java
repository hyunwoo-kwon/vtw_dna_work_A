package com.vtw.dna.screen.repository;

import com.vtw.dna.screen.Screen;
import com.vtw.dna.screen.ScreenRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenRoomRepository extends JpaRepository<ScreenRoom, Long> {

    ScreenRoom findByScreenRoomSeq(Long screenRoomSeq);

    Page<ScreenRoom> findAll(Pageable pageable);

}
