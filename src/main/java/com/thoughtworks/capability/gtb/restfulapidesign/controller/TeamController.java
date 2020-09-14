package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import com.thoughtworks.capability.gtb.restfulapidesign.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/teams")
public class TeamController {
    final TeamService teamService;


    public TeamController(TeamService teamService, StudentService studentService) {
        this.teamService = teamService;
    }

    @GetMapping("")
    public List<Team> getTeams(){
        return teamService.getTeams();
    }

    @GetMapping("/grouping")
    public List<Team> groupTeams(){
        teamService.grouping();
        return teamService.getTeams();
    }

    @PatchMapping("/{id}")
    public Team updateGroupName(@PathVariable int id, @RequestParam String teamName) {
        return teamService.updateTeamName(id, teamName);
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable  Integer id){
        return teamService.getTeamById(id);
    }
}
