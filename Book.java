class Book{

   String title;

   int publicationYear;

	public Book(String title,int publicationYear){

	    this.title=title;

		this.publicationYear=publicationYear;

	}

	public void displayInfo(){

	    System.out.println("Title --> "+title);

		System.out.println("Publication Year --> "+publicationYear);

	}

}

class Author extends Book{

   String name;

	String bio;

	public Author(String title,int publicationYear,String name,

     String bio){

	    super(title,publicationYear);

		this.name=name;

		this.bio=bio;

	}

	@Override

	public void displayInfo(){

	    super.displayInfo();

		System.out.println("Author Name --> "+name);

		System.out.println("Author Bio --> "+bio);

	}

}

public class LibraryManagement{

   public static void main(String[] args){

	    Author book1=new Author("The Hitchhiker's Guide to the Galaxy",

         1979,"Douglas Adams",

         "A British author and humorist.");

	    Author book2=new Author("To Kill a Mockingbird",1960,

         "Harper Lee","An American novelist");

	    Author book3=new Author("1984",1949,"George Orwell",

         "An English novelist and essayist");

		book1.displayInfo();

		System.out.println();

		book2.displayInfo();

		System.out.println();

		book3.displayInfo();

	}

}
