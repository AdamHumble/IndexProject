# ArrayLists and Trees
You may have seen, at the back of books, an index.  There are many sophisticated indexing programs out there - we will be building one that is not as fancy but still rather cool. 

Here is the basic algorithm

* Ask the user for a plain text file
* Create an ArrayList of *Binary Search trees*. You will need at least 26 elements (one for each letter of the alphabet), and you may need more.  To make things easier on yourself - Element[0] is "A", [1] is "B", etc.
* Read in the text file
* Split it in to words, but there are some things you need to take in to account while you are doing this
* If the first letter of the word is an "A", put the word in the BST that is in ArrayList[0].   You will need to make sure it goes in "In Order" so that AA appears before AB when printed out. 
  * What about lowercase? Remember the ASCII table.  You may have to do some work to get the elements to be in alphabetical rather than ASCII order. 
* Do not add spaces or any punctuation that is part of the word (like open/closed quotes, periods, exclamation marks, etc.)  to the entry. However, if a special character is by itself, then add it. 
* Include in the Tree Entry the word, the line number of the file, and the page number
  * Page number? Let's assume each page is 75 lines long. So a word on line 100 is on page 2, line 25.  

When you have everything in each of the trees. print out the trees in order. So, all the A words are printed in lexical order, then all the B words, .... 

~~~
Word   Page   Line

Alpha   2   25

 ...

~~~

In addition to printing to the screen, please print your results to a text file. The filename needs to include the name of the document you are parsing.

The BST needs to be in its own class (or classes). You must write object-oriented code. 

Error correction is assumed -- for example, if a file doesn't exist, gracefully allow them to re-enter the name. You must use exception handling as appropriate. 

If you do not have complete INPUT, PROCESSING, OUTPUT for every method, complete documentation for every class, etc, you will not do well on this assignment. You've have loads of practice by now.  

## Now it's your turn

Based on the examples from in class, make sure every file, class, method, and variable has a JavaDoc documentation section. 

When you have finished all of your code and documentation:

In the Shell, type
~~~
javadoc *.java -author -version
~~~
In the Shell, type  (yes, it's a python command. That is correct)
~~~
python -m http.server
~~~
and you should see your documentation. 

Click on the links you created above to make sure you can see both sets of documentation.

Click/type __control-C__ to stop the http server. 

Once your documentation looks correct & professional, submit your work. 

  ![alt text](assets/logotype.png)


## A reminder from the syllabus:
*Your code must work. It must be syntactically and logically correct. If not, your grade will be marked down. Repeated attempts to submit incorrect code will result in lower and lower scores.*

*Did you find a code snippet online that you feel you must use in a project/lab/assignment? Great. Go ahead... BUT there are TWO Conditions (otherwise, sorry to say, it is plagiarism/cheating):*

- *Cite your work. Note exactly where you got the code snippet. Include the URL and the date you found the code and all other info you think will be necessary*

- *Explain, in significant detail and in your own words, exactly what the code does. Include comments on what changes you had to make to get the code to work in your own project.*

*If you use code from the notes (that was not given to you as part of the assignment), just make a comment that the block of code that follows is from the class notes.*

*As you advance in your career, you will find that the discipline to create, test, and release properly working code will be beneficial.*

*__All work must be created in the current semester for this course. Work created in previous semesters, even for a previous section of this course, and/or work created for a different course, regardless of when it was created will not be accepted and will receive a zero.__*

*Unless I explicitly designate an assignment as a group assignment, work must be yours alone. Do not copy from another student or website, and do not allow someone else to copy from you. It is acceptable and encouraged to discuss concepts involved with other students, but do not look at their work or show your work to someone else*

*You will always be asked to apply what you have learned in your readings and labs from not only the current chapter, but from information previously presented in the course as well as your prerequisite coursework.*

# Deliverables

The following items should be submitted to Blackboard please

## Project Link 
> the full link to your code replit.com. This is so Blackboard sees a place to put your grade.  *If you forget to do this, your project will earn a zero*. 

### Code Note 
> For the main program, and for every function you wrote or used, please list and describe using JavaDoc notation
1.	All input variables
2.	All processing / manipulation for each variable
a.	Include your flowcharts and/or pseudo code for each item
b.	Include all information that a developer from a different department could use to completely test each function.
3.	All output variables, including any additional information presented to the user to aid in their understanding of your work


## A Paper, saved as yourLastName_paper.pdf
> Save your paper as a PDF and then discuss the following items:

**Introduction**
> Introduce your project (a paragraph or two)

**Discussion**
> Describe your project
Discuss your code (at a high level). What it does/doesn’t to, what worked, what didn’t work, what you chose not to implement, etc.
What else do you want to tell us about this work that wasn’t asked? 

**Ethics Discussion (not everything will apply, but you should completely address all ethical issues)**

1.All systems require data coming in to and out of the application. For your project:

a.	How did you ensure that the data coming into the project was as clean as you can make it? (No malicious code, no garbage that will cause crashes, etc.)

b.	If you are reading from/writing to files, how are you ensuring that file is not easily accessible by the user of the application (for example file name obfuscation, using a database, storing the file in a different location than the project, …)

c.	If the program is run multiple times, how are you preventing data loss when the file is opened? (examples: appending, new file names each time, …) 

d.	Investigate *one professional (ACM, IEEE, ….) **and** one industry (your choice, related to the area you want to work in) Code of Ethics*.  So you will have two different documents.

i.	Describe both codes (which code, who are they written for, and so on)

ii.	Compare and contrast the codes and your own ideas/behaviors to date with respect to the following items:

   a. Academic honesty/integrity

   b. Ability to perform IT tasks and learn new skills while working with a current skill set
   
   c. Ability to keep program logic and data confidential as required

**Appendices**

Include a list of all resources you used to do the work.  Create the list using the ACM citation style.  For each resource, please list the following

i.	What problem(s) were you having that required you to seek outside help? (be sure and list everything)

ii.	How did you manipulate/change what you found into what you needed to solve the issue? 

iii.	What new items did you learn, even one that you can’t use on this assignment but may be useful elsewhere?

The ACM Style is here: https://www.acm.org/publications/authors/reference-formatting


## Presentation

**The presentation**

The goal of the presentation is primarily to teach the class about your project and your experiences. The presentation will be used to discuss the following:

- Introduction: Who are you? (introduce yourself please)
- What is your product (be detailed here)?
- Project discussion: Time it took you from the very start to the very end; Status of code work; What you have learned about coding
- Ethics and Security discussions: what you learned on these topics
- Live demo of your work
- Conclusions: Future work; What you would do differently
- Include a short discussion of the items you wish to expand on after this class is over – what else do you want to learn?
- Wrap up (thank yous and ask for questions / comments)

Make sure you practice your demonstration and discussion.

Your summary of your experiences can be at whatever level of detail you think is interesting or informative. Given the time limit, selecting and highlighting the two or three most important or interesting observations is likely more useful than trying to be complete.

Be aware that short presentations are more difficult than long ones. Ensure that you get to the point quickly and eliminate all information that is not essential. However, still provide sufficient context information that the key issue and your reflection are understandable for your target audience. Your primary target audience is your fellow students.

You will create this presentation as a video and post the video on the portal. Because of privacy issues, the video must be posted on the portal - videos on Google Drive, YouTube, and the like will not be accepted.  Unless we are looking at something specifically regarding your project, your face needs to be on the screen. You can be picture-in-picture or full screen, your choice.  If this might be an issue, for any reason, please contact me asap. (well before this assignment is due)  

*Length: 10-15 minutes*

Please practice before recording, so we don't hear as many uhm er ah uh ... 

Make sure it is professional --  dress appropriately and be aware of the background and items / people / animals around & behind you. 

Post your video in the class Assignments folder (instructions in the Final Project folder on our course site)

Head over to the discussion forum. Create a post

- Post a WRITTEN version of an "Elevator Pitch" about your project:
    - Introduce your project in a paragraph or so
    - Tell everyone what you are you most proud of (and why)
    - Tell everyone the items that worked really well
    - Tell everyone the items that didn't work, that you didn't get to (from your original scope of work), things that went sideways for some reason. Tell us why you think things didn't go as planned
    - For the things that didn't go well, ask your classmates for input on ideas to solve any issues you might have had.
- These can be a challenge to write - so work on it as you go along. Read it out loud to your pet, sibling, child, stuffed animal, or the like and - in a normal conversational voice - read exactly what is on the paper in about 2 minutes and 30-45 seconds. Then it's long enough. 


After you complete your post, you need to respond to 50% of your classmates' posts, answering their questions and such.  You have to watch everyone's video, so post as you are watching them. Follow the instructions from the posting the video document to find everyone's videos.  

Please note -- everyone will be watching your video and responding on them.  
