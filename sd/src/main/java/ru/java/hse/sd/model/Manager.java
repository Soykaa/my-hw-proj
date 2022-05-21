package ru.java.hse.sd.model;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.java.hse.sd.model.hibernate.Attempt;
import ru.java.hse.sd.model.hibernate.Checker;
import ru.java.hse.sd.model.hibernate.Homework;
import ru.java.hse.sd.model.hibernate.Storage;
import ru.java.hse.sd.model.view.AttemptView;
import ru.java.hse.sd.model.view.HomeworkView;
import ru.java.hse.sd.model.view.MarkView;

public class Manager {
    public List<HomeworkView> homeworks() {
        try (Session session = Storage.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Homework> cr = cb.createQuery(Homework.class);
            Root<Homework> root = cr.from(Homework.class);
            cr.select(root);
            Query<Homework> query = session.createQuery(cr);
            List<Homework> homeworks = query.getResultList();
            return homeworks.stream()
                .map(a -> new HomeworkView(
                    a.getId(),
                    a.getName(),
                    a.getPublicationDate(),
                    a.getTaskDescription(),
                    a.getDeadline(),
                    a.getCheckerId()
                )).collect(Collectors.toList());
        }
    }

    public void submit(String homeworkId, String solutionUrl) {

    }

    public List<AttemptView> results() {
        try (Session session = Storage.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Attempt> cr = cb.createQuery(Attempt.class);
            Root<Attempt> root = cr.from(Attempt.class);
            cr.select(root);
            Query<Attempt> query = session.createQuery(cr);
            List<Attempt> attempts = query.getResultList();
            Map<String, HomeworkView> homeworks = homeworks().stream()
                .collect(Collectors.toMap(HomeworkView::id, Function.identity()));
            return attempts.stream()
                .map(a -> new AttemptView(
                    homeworks.get(a.getHomeworkId()),
                    new MarkView(a.getMark().name()),
                    a.getComment(),
                    a.getDateTime())
                ).collect(Collectors.toList());
        }
    }

    public void addHomework(HomeworkView homework) {
        try (Session session = Storage.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Homework homeworkModel = new Homework(homework.id(), homework.name(), homework.publicationDate(),
                homework.taskDescription(), homework.deadline(), homework.checkerId());
            try {
                session.save(homeworkModel);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw new RuntimeException(e);
            }
        }
    }

    public void addChecker(String id, String code) {
        try (Session session = Storage.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Checker checker = new Checker(id, code);
            try {
                session.save(checker);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                throw new RuntimeException(e);
            }
        }
    }
}
