// importare alcune cose
//import  { Book , Categories as MyCategories } from './modules/book'
//importare tutto
import * as  books from './modules/book'

import  Book from './modules/book'
//console.log(books.Categories)
//console.log(Categories)

//;console.log(MyCategories)
let book = new Book();
book.year = 2017
book.title =' My story';
book.content = 'ddd'
console.log(book)