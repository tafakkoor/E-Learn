package com.tafakkoor.englishlearningplatform.service;

import com.tafakkoor.englishlearningplatform.dao.*;
import com.tafakkoor.englishlearningplatform.domains.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

import static java.lang.ThreadLocal.withInitial;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class TeacherService {
    private static final ThreadLocal<TeacherService> instance = ThreadLocal.withInitial(TeacherService::new);


    public static TeacherService getInstance() {
        return instance.get();
    }

    public Story getStoryById(int id) {
        return new StoryDAO().findById(id);
    }

    public List<Vocabulary> getVocabulariesByStory(int id) {
        return new VocabularyDAO().getVocabulariesByStoryId(getStoryById(id));
    }

    public List<Story> getAllStories() {
        return new StoryDAO().findAllStories();
    }

    public List<Grammar> getAllGrammars() {
        return GrammarDAO.getInstance().findAllGrammars();
    }

    public void saveQuestion(Questions questions) {
        QuestionDAO questionsDAO = new QuestionDAO();
        questionsDAO.save(questions);

    }

    public void saveVariant(Variants variants) {
        VariantDAO variantDAO = new VariantDAO();
        variantDAO.save(variants);
    }

    public Grammar getGrammarById(int grammarId) {


        return GrammarDAO.getInstance().findById(grammarId);
    }

    public void deleteWord(int id) {
        VocabularyDAO vocabularyDAO = new VocabularyDAO();
        Vocabulary vocabulary = vocabularyDAO.findById(id);
        vocabulary.setDeleted(true);
        vocabularyDAO.save(vocabulary);
    }

    public void updateAsDelete(Story story) {
        StoryDAO storyDAO = new StoryDAO();
        storyDAO.update(story);
    }
    public void updateStory(Story story) {
        StoryDAO storyDAO = new StoryDAO();
        storyDAO.update(story);
    }
}
