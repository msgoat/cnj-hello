package group.msg.at.cloud.cloudtrain.adapter.rest;

import group.msg.at.cloud.cloudtrain.core.boundary.HelloWorld;
import group.msg.at.cloud.cloudtrain.core.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/hello")
@CrossOrigin
public class HelloController {

    @Autowired
    HelloWorld boundary;

    @GetMapping
    public ResponseEntity<Message> getWelcomeMessage() {
        return ResponseEntity.ok(boundary.getHelloMessage());
    }
}
