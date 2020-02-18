package sprint.exceptions;

public class CvvNotMatchException extends Exception{
		public CvvNotMatchException()
		{
			System.out.println("Wrong CVV! provide correct CVV!");
		}
}
