package com.vtw.dna.movie.controller;

import com.vtw.dna.movie.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void list() throws Exception {

        List<Movie> movieList = new ArrayList<Movie>();

//        Movie movie= new Movie("테스트","test","20200303","테스트 디테일입니다.",9000);

//        for(int i = 0 ; i <10 ; i++){
//
//            mockMvc.perform(post("/movie/insert").param("krName","테스트"+i)
//                                                            .param("enName","enNameTest"+i)
//                                                            .param("releaseDate","enNameTest"+i)
//                                                            .param("detail","enNameTest"+i)
//                                                            .param("fee",Integer.toString(9000+i)));
//
//        }

//        System.out.println("!!!! insert screenRoom");
//        mockMvc.perform(post("/screenRoom/insert").param("totalSeatLow","E")
//                .param("totalSetColumn","5"));
//
//        System.out.println("!!!! insert screenRoomSeat");
//        mockMvc.perform(post("/screenRoomSeat/insert").param("screenRoomSeq","1"));
//
//
//        System.out.println("!!!! update screenRoomSeat");
//        mockMvc.perform(post("/screenRoomSeat/update")
//                        .param("screenRoomSeq","1")
//                        .param("seatLow","A")
//                        .param("seatColumn","1")
//                        .param("useYn","N")
//                );
//
//
//        System.out.println("!!!! update screenRoomSeat");
//        mockMvc.perform(post("/screenRoomSeat/update")
//                .param("screenRoomSeq","1")
//                .param("seatLow","E")
//                .param("seatColumn","3")
//                .param("useYn","N")
//        );
//
//
//        System.out.println("!!!! insert screenRoomSeat fullSeat!!!!!!!!!!!!!!!!!");
//        System.out.println("!!!! insert screenRoomSeat fullSeat!!!!!!!!!!!!!!!!!");
//        mockMvc.perform(post("/screenRoomSeat/fullSeat").param("screenRoomSeq","1"));
//
//        System.out.println(" ");
//        System.out.println("!!!! insert screenRoomSeat fullSeat   EEEEEEEEEEEENNNNNNNNNNNNND!!!!!!!!!!!!!!!!!");
//        System.out.println("!!!! insert screenRoomSeat fullSeat   EEEEEEEEEEEENNNNNNNNNNNNND!!!!!!!!!!!!!!!!!");
//
//        System.out.println("!!!! insert movie");
//        mockMvc.perform(post("/movie/insert").param("krName","범죄의 도시3")
//                                                            .param("enName","madongsuck city 3")
//                                                            .param("releaseDate","20230303")
//                                                            .param("detail","마동석과 함께하는 진실의 방으로")
//                                                            .param("fee",Integer.toString(9000)));
//
//        System.out.println("!!!! insert screen");
//        mockMvc.perform(post("/screen/insert").param("movieSeq","1")
//                                                            .param("screenDate","20230303")
//                                                            .param("screenRound","1")
//                                                            .param("startTime","0800")
//                                                            .param("endTime","1010"));
//
//        System.out.println("!!!! insert discountpolicy");
//        mockMvc.perform(post("/discountpolicy/insert").param("movieSeq","1")
//                .param("policyType","2")
//                .param("polictPrice","10")
//                .param("policyRate","10"));
//
//        System.out.println("!!!! insert discountcondition");
//        mockMvc.perform(post("/discountcondition/insert").param("discountPolicySeq","1")
//                .param("conditionType","1")
//                .param("dateDay","6")
//                .param("conditionRound","1")
//                .param("conditionStartTime","0")
//                .param("conditionEndTime","0"));
//
//        mockMvc.perform(post("/screen/calcfee").param("screenSeq","1"));

//        System.out.println("!!!! select All screen");
//        mockMvc.perform(post("/screen/selectAll"));


//        mockMvc.perform(get("/movie"));
    }
}