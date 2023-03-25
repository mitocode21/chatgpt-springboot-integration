package com.mitocode.controller;

import com.mitocode.dto.ResponseDTO;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final ChatgptService chatgptService;

    @PostMapping("/send")
    public ResponseDTO<String> send(@RequestBody String message){
        log.info("message is: {}", message);
        String responseMessage = chatgptService.sendMessage(message);
        log.info("response is: {}", responseMessage);

        return ResponseDTO.success(responseMessage);
    }
}
