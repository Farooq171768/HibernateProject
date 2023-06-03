package cgginterns.hibernate.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		// creating question object
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is Java?");

		// creating answer object
		Answer answer = new Answer();
		answer.setAnswerId(343);
		answer.setAnswer("Java is a programming language.");

		q1.setAnswer(answer);
		//Setting question
		answer.setQuestion(q1);

		// creating question object
		Question q2 = new Question();
		q2.setQuestionId(242);
		q2.setQuestion("What is collection framework?");

		// creating answer object
		Answer answer1 = new Answer();
		answer1.setAnswerId(344);
		answer1.setAnswer("API to work with group of objects.");

		//Setting answer
		q2.setAnswer(answer1);
		//Setting question
		answer1.setQuestion(q2);
		
		
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(q1);
		s.save(q2);
		s.save(answer);
		s.save(answer1);
		
		
		tx.commit();
		
		//Fetching questions
//		Question question =(Question)s.get(Question.class,242);
//		System.out.println(question.getQuestion());
//		System.out.println(question.getAnswer().getAnswer());
		
		Answer ans=(Answer)s.get(Answer.class,344);
		System.out.println(ans.getAnswer());
		System.out.println(ans.getQuestion().getQuestion());
		
		
		
		
		s.close();
		factory.close();
	}

}
