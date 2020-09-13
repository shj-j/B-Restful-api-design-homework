package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final StudentRepository studentRepository;

    public TeamService(TeamRepository teamRepository, StudentRepository studentRepository) {
        this.teamRepository = teamRepository;
        this.studentRepository = studentRepository;
    }

    public List<Team> getTeams() {
        return teamRepository.getTeamList();
    }

    public Map<Integer, List<Student>> mapStudents(){
        List<Student> studentList = studentRepository.findAll();
        Collections.shuffle(studentList);

        Map<Integer, List<Student>> map = new HashMap<>();
        map.put(1, new ArrayList<>());
        map.put(2, new ArrayList<>());
        map.put(3, new ArrayList<>());
        map.put(4, new ArrayList<>());
        map.put(5, new ArrayList<>());
        map.put(6, new ArrayList<>());

        for (int i = 0; i < studentList.size(); i++){
            int index = (i % 6) + 1;
            map.get(index).add(studentList.get(i));
        }
        return map;
    }

    public void grouping() {
        Map<Integer, List<Student>> teamGrouping = mapStudents();
        teamRepository.save(teamGrouping);
    }

    public Team updateTeamName(int id, String teamName) {
        Team team = teamRepository.findById(id);
        if(team != null) {
            team.setTeamName(teamName);
        }
        return null;
    }

    public Team getTeamById(Integer id) {
        return teamRepository.findById(id);
    }
}
