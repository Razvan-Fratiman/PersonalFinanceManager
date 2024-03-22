package com.fiipractic.pfm.service;

import com.fiipractic.pfm.dto.KeywordDto;
import com.fiipractic.pfm.model.Keyword;
import com.fiipractic.pfm.repository.KeywordRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KeywordService {
    @Autowired
    private KeywordRepository keywordRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Keyword> getAllKeywords() {
        return keywordRepository.findAll();
    }

    public Optional<Keyword> getKeywordById(Long keywordId) {
        return keywordRepository.findById(keywordId);
    }

    public Keyword createKeyword(Keyword newKeyword) {
        return keywordRepository.save(newKeyword);
    }

    public Keyword updateKeyword(Keyword keyword, Long keywordId) {
        Keyword existingKeyword = keywordRepository.findById(keywordId).orElseThrow();
        existingKeyword.setValue(keyword.getValue());
        existingKeyword.setParentId(keyword.getParentId());
        return keywordRepository.save(existingKeyword);
    }

    public String deleteKeyword(Long keywordId) {
        keywordRepository.deleteById(keywordId);
        return "Keyword deleted successfully";
    }

    public KeywordDto convertToDto(Keyword keyword) {
        return modelMapper.map(keyword, KeywordDto.class);
    }
}
