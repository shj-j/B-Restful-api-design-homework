package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Team;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TeamRepository {
    private final static List<Team> teamList = new ArrayList<>();

    static {
        teamList.add(Team.builder().teamId(1).teamName("Team 1").build());
        teamList.add(Team.builder().teamId(2).teamName("Team 2").build());
        teamList.add(Team.builder().teamId(3).teamName("Team 3").build());
        teamList.add(Team.builder().teamId(4).teamName("Team 4").build());
        teamList.add(Team.builder().teamId(5).teamName("Team 5").build());
        teamList.add(Team.builder().teamId(6).teamName("Team 6").build());
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void save(Map<Integer, List<Student>> teamMap) {
        for(int i = 0 ; i < 6 ; i++ ){
            teamList.get(i).setStudentsList(teamMap.get(i+1));
        }
    }

    public Team findById(int id) {
        return teamList.get(id-1);
    }
}
