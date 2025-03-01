package eu.hackathon.utopia.controllers;


import eu.hackathon.utopia.domain.Act;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api/act")
@RequiredArgsConstructor
public class actController {

    public ResponseEntity<Act> createAct(@RequestBody actDto dto) {
        Act act = new Act();

        act.setName(dto.getName());
        act.setDescription(dto.getDescription());

        Random random = new Random();
        int randomAmount = 1 + random.nextInt(6);

        act.setPoints(randomAmount);

        return ResponseEntity.ok(act);
    }


}
