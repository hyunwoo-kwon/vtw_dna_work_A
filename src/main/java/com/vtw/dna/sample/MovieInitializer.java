package com.vtw.dna.sample;

import com.vtw.dna.movie.Movie;
import com.vtw.dna.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieInitializer implements SampleDataInitializer{

    private final MovieRepository repository;

    @Autowired
    public MovieInitializer(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public void generateData() {

        Movie movie1 = new Movie("마녀","The Other One", "20220615", "통제불능의 존재가 세상 밖으로 나왔다!자윤이 사라진 뒤, 정체불명의 집단의 무차별 습격으로 마녀 프로젝트가 진행되고 있는 아크가 초토화된다.그곳에서 홀로 살아남은 ‘소녀’는 생애 처음 세상 밖으로 발을 내딛고우연히 만난 ‘경희’의 도움으로 농장에서 지내며 따뜻한 일상에 적응해간다.한편, 소녀가 망실되자 행방을 쫓는 책임자 장과마녀 프로젝트의 창시자 백총괄의 지령을 받고 제거에 나선 본사 요원 조현,경희의 농장 소유권을 노리는 조직진 마녀가 온다."
                ,"https://img.cgv.co.kr/Movie/Thumbnail/Poster/000085/85871/85871_1000.jpg",12000);

        Movie movie2 = new Movie("탑건-매버릭","Top Gun: Maverick", "20220622", "한순간의 실수도 용납되지 않는 하늘 위, \n" +
                "가장 압도적인 비행이 시작된다!\n" +
                "\n" +
                "최고의 파일럿이자 전설적인 인물 매버릭(톰 크루즈)은 자신이 졸업한 훈련학교 교관으로 발탁된다. \n" +
                "그의 명성을 모르던 팀원들은 매버릭의 지시를 무시하지만 실전을 방불케 하는 상공 훈련에서 눈으로 봐도 믿기 힘든 전설적인 조종 실력에 모두가 압도된다. \n" ,"https://img.cgv.co.kr/Movie/Thumbnail/Poster/000082/82120/82120_320.jpg",11000);

        Movie movie3 = new Movie("버즈라이트이어","Lightyear", "20220615", "우주 저 너머 운명을 건 미션, 무한한 모험이 시작된다!\n" +
                "\n" +
                "미션 #1\n" +
                "나, 버즈 라이트이어.\n" +
                "인류 구원에 필요한 자원을 감지하고 현재 수많은 과학자들과 미지의 행성으로 향하고 있다.\n" +
                "이번 미션은 인류의 역사를 새롭게 쓸 것이라 확신한다. ","https://img.cgv.co.kr/Movie/Thumbnail/Poster/000085/85977/85977_320.jpg",13000);

        create(movie1);
        create(movie2);
        create(movie3);

    }

    private void create(Movie movie){
        repository.save(movie);
    }
}
