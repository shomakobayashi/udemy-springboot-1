package com.example.demo.controller;

import com.example.demo.entity.IssueEntity;
import com.example.demo.form.IssueForm;
import com.example.demo.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

@Controller
@RequestMapping("/issues")
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;

    @GetMapping()
    public String showList(Model model) {
        model.addAttribute("issueList", issueService.findAll());
        return "issues/list";
    }

    @GetMapping("/creationForm")
    public String showCreateForm(@ModelAttribute IssueForm form) {
        return "issues/creationForm";
    }

    //post /issues
    @PostMapping("")
    public String create(@Validated IssueForm form, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return showCreateForm(form);
        }

        issueService.create(form.getSummary(), form.getDescription());
        //return showList(model); //
        return "redirect:/issues";
    }

    // GET localhost:8080/issues/1
    //ビューに渡すissueEntityを用意する
    @GetMapping("/{issueId}")
    public String showDetail(@PathVariable("issueId") long issueId, Model model) {
        model.addAttribute("issue", issueService.findById(issueId));
        //ビュー名を指定（HTMLファイル名）
        return "issues/detail";
    }
}
