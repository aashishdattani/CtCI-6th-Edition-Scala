# Solutions in Scala for CtCI-6th-Edition

This repository contains Scala solutions for [Cracking the Coding Interview 6th Edition](http://www.amazon.com/Cracking-Coding-Interview-6th-Edition/dp/0984782850) by [Gayle Laakmann McDowell](http://www.gayle.com/).

## Project Layout

The entire project was created using IntelliJ Scala (using sbt) and follows an sbt defined directory structure. Each chapter is a high level package with sub-packages for each question. Code files are of the form `src/main/scala/ch<i>/q<j>/<filename.scala>` and the respective test is of the form `src/test/scala/ch<i>/q<j>/<testfile.scala>`.

## Running the code

The code can be compiled using IntelliJ or through following command on the console:

`sbt build`

The tests can be built and run using the following command:

`sbt test`

## Contributing

Please feel free to contribute with more tests and alternative solutions to what has been proposed here.
