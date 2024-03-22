package com.fiipractic.pfm.controller;

import com.fiipractic.pfm.dto.KeywordDto;
import com.fiipractic.pfm.model.Keyword;
import com.fiipractic.pfm.service.KeywordService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class KeywordsController {
    @Autowired
    private KeywordService keywordService;

//    @GetMapping("/keywords")
//    @ResponseStatus(HttpStatus.OK)
//    public List<Keyword> getAllKeywords() {
//        return keywordService.getAllKeywords();
//    }

    @GetMapping("/keywords")
    @ResponseStatus(HttpStatus.OK)
    public List<KeywordDto> getAllKeywords(){
        List<Keyword> keywords = keywordService.getAllKeywords();
        return keywords.stream().map(keywordService::convertToDto)
                .toList();
    }
//    @GetMapping("/keywords/{keywordId}")
//    @ResponseStatus(HttpStatus.OK)
//    public Keyword getKeywordById(@PathVariable Long keywordId) {
//        return keywordService.getKeywordById(keywordId).orElseThrow();
//    }

    @GetMapping("/keywords/{keywordId}")
    @ResponseBody
    public KeywordDto getKeywordById(@PathVariable Long keywordId) {
        return keywordService.convertToDto(keywordService.getKeywordById(keywordId).orElseThrow());
    }

    @PostMapping("/keywords/create")
    @ResponseStatus(HttpStatus.CREATED)
    public KeywordDto createKeyword(@RequestBody Keyword newKeyword) {
        return keywordService.convertToDto( keywordService.createKeyword(newKeyword));
    }

    @PutMapping("/keywords/update-keyword/{keywordId}")
    @ResponseStatus(HttpStatus.OK)
    public KeywordDto updateKeyword(@RequestBody Keyword newKeyword, @PathVariable Long keywordId) {
        return keywordService.convertToDto(keywordService.updateKeyword(newKeyword, keywordId));
    }

    @DeleteMapping("/keywords/delete-keyword/{keywordId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteKeyword(@PathVariable Long keywordId) {
        return keywordService.deleteKeyword(keywordId);
    }
}
