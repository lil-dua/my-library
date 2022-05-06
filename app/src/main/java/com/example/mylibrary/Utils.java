package com.example.mylibrary;

import java.util.ArrayList;

public class Utils  {

    private static Utils instance;
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> favoriteBook;

    public Utils(){
        if(null == allBooks){
            allBooks = new ArrayList<>();
            initData();
        }
        if (null == favoriteBook){
            favoriteBook = new ArrayList<>();
        }
    }

    private void initData() {
        //TODO: add initial data
        allBooks.add(new Book(1,"1984","George Orwell",328,"https://www.oberlo.com/media/1603897567-image39-1.jpg?fm=webp&w=1824&fit=max","1984 tells the futuristic story of a dystopian, totalitarian world where free will and love are forbidden. Although the year 1984 has long since passed, the prophecy of a society controlled by fear and lies is arguably more relevant now than ever."));
        allBooks.add(new Book(2,"The Lord of the Rings","J.R.R. Tolkien",1216,"https://www.oberlo.com/media/1603897585-image12-1.jpg?fm=webp&w=1824&fit=max","Tolkien’s fantasy epic is one of the top must-read books out there. Set in Middle Earth – a world full of hobbits, elves, orcs, goblins, and wizards – The Lord of the Rings will take you on an unbelievable adventure."));
        allBooks.add(new Book(3,"The Kite Runner","Khaled Hosseini",400,"https://www.oberlo.com/media/1603897583-image17-1.jpg?fm=webp&w=1824&fit=max","The Kite Runner is a moving story of an unlikely friendship between a wealthy boy and the son of his father’s servant. Set in Afghanistan during a time of tragedy and destruction, this unforgettable novel will have you hooked from start to finish."));
        allBooks.add(new Book(4,"Harry Potter and the Philosopher’s Stone","J.K. Rowling",226,"https://www.oberlo.com/media/1603897577-image22-1.jpg?fm=webp&w=1824&fit=max","This global bestseller took the world by storm. So, if you haven’t read J.K. Rowling’s Harry Potter, now may be the time. Join Harry Potter and his schoolmates as this must-read book transports you deep into a world of magic and monsters."));
        allBooks.add(new Book(5,"Slaughterhouse-Five","Slaughterhouse-Five",288,"https://www.oberlo.com/media/1603897566-image41.jpg?fm=webp&w=1824&fit=max","Slaughterhouse-Five is arguably one of the greatest anti-war books ever written. This rich and amusing tale follows the life of Billy Pilgrim as he experiences World War II from a peculiar perspective."));
        allBooks.add(new Book(6,"The Lion, the Witch, and the Wardrobe","C.S. Lewis",208,"https://www.oberlo.com/media/1603897587-image5.jpg?fm=webp&w=1824&fit=max","The Lion, The Witch, and the Wardrobe is undoubtedly one of the great books of all time. This renowned fantasy novel is set in Narnia, home to mythical beasts, talking animals, and warring kingdoms. The story follows a group of school children as they become entangled in this incredible world’s fate."));
        allBooks.add(new Book(7,"To Kill a Mockingbird","Harper Lee",281,"https://www.oberlo.com/media/1603897587-image7.jpg?fm=webp&w=1824&fit=max","To Kill a Mockingbird is one of the top must-read books of all time. Published in 1960, the story explores life in the Deep South during the early 20th century through the story of a man accused of a terrible crime. It’s poignant, humorous, and gripping."));
        allBooks.add(new Book(8,"The Book Thief","Markus Zusak",608,"https://www.oberlo.com/media/1603897566-image40-1.jpg?fm=webp&w=1824&fit=max","The Book Thief is a story of bravery, hope, and friendship in a time of Nazi tyranny. Narrated by Death itself, this novel will have you holding your breath for chapters at a time."));

    }


    public static  Utils getInstance(){

        if(null != instance){
            return instance;
        }else {
            instance = new Utils();
            return instance;
        }
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getFavoriteBook() {
        return favoriteBook;
    }

    public Book getBookByID(int id){
        for (Book b:
             allBooks) {
            if (b.getId()==id){
                return b;
            }

        }
        return null;
    }

    public boolean addToFavoriteBook(Book book){
        return favoriteBook.add(book);
    }

}
