package by.jnetworks.pagereducer.controller;

import by.jnetworks.pagereducer.service.PageReducer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reduce")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AliceController {

    private final PageReducer pageReducer;

    @GetMapping
    public String reducePage(@RequestParam String pageNumbers) {
        return pageReducer.reducePages(pageNumbers);
    }
}
