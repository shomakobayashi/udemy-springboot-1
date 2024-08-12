package com.example.demo.service;

import com.example.demo.entity.IssueEntity;
import com.example.demo.repository.IssueRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class IssueService {

    @Autowired
    private final IssueRepository issueRepository;

    public List<IssueEntity> findAll() {
        return issueRepository.findAll();
//        return List.of(
//                new IssueEntity(1, "概要1", "説明1"),
//                new IssueEntity(2, "概要2", "説明2"),
//                new IssueEntity(3, "概要3", "説明3")
//        );
    }

    @Transactional
    public void create(String summary, String description) {
        //ビジネスロジックとデータアクセスを分離するために、repositoryを呼ぶだけの構造
        //三層分離を明確にする
        //TODO トランザクション
        issueRepository.insert(summary, description);

        //後処理が増えたとする
        //必ず失敗するメソッド
        //throw new IllegalStateException("NG");
    }

    public IssueEntity findById(long issueId) {
            return issueRepository.findById(issueId);
        }
}
