package cgginterns.hibernate.map1;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo1 {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		// creating question object
		Question q = new Question();
		q.setQuestionId(1212);
		q.setQuestion("What is Java?");

		// creating answer objects
		Answer a = new Answer();
		a.setAnswerId(343);
		a.setAnswer("Java is a programming language");
		a.setQuestion(q);

		Answer a1 = new Answer();
		a1.setAnswerId(344);
		a1.setAnswer("Java is platform independent languge");
		a1.setQuestion(q);

		Answer a2 = new Answer();
		a2.setAnswerId(345);
		a2.setAnswer("Java is a strongly typed language");
		a2.setQuestion(q);

		ArrayList<Answer> list = new ArrayList<>();
		list.add(a);
		list.add(a1);
		list.add(a2);

		q.setAnswers(list);

		Question q1 = new Question();
		q1.setQuestionId(234);
		q1.setQuestion("What is NetBeans?");

		// creating answer objects
		Answer a3 = new Answer();
		a3.setAnswerId(173);
		a3.setAnswer("NetBeans is an IDE");
		a3.setQuestion(q1);

		Answer a4 = new Answer();
		a4.setAnswerId(346);
		a4.setAnswer("NetBeans can be used to build any type of App");
		a4.setQuestion(q1);

		Answer a5 = new Answer();
		a5.setAnswerId(347);
		a5.setAnswer("NetBeans is a popular IDE");
		a5.setQuestion(q1);

		ArrayList<Answer> list1 = new ArrayList<>();
		list1.add(a3);
		list1.add(a4);
		list1.add(a5);

		q1.setAnswers(list1);

		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();

		s.save(q);
		s.save(a);
		s.save(a1);
		s.save(a2);

		s.save(q1);
		s.save(a3);
		s.save(a4);
		s.save(a5);

		tx.commit();

		// fetching
		Question question= (Question)s.load(Question.class, 1212);
		System.out.println(question.getQuestion());
		//System.out.println(question.getAnswers());
		
		for(Answer answer : question.getAnswers()) {
			 System.out.println(answer.getAnswer());
		}
		s.close();
		
		factory.close();
	}

}
