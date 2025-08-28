# Basic Shell Commands

| Command | Description                         |
|---------|-------------------------------------|
| `pwd`   | Print current working directory     |
| `cd`    | Change working directory            |
| `ls`    | List files in working directory     |
| `man`   | Bring up manual for a command       |
| `exit`  | Log out of shell                    |
| `man`   | Print documentation of a command    | 

# Man Pages (Documentation)

Documentation for Linux is built-in and can be accessed using the `man` (manual) command.

For example:

```bash
$ man ls
```

This provides the documentation for `ls`.

---

## Helpful Notes for Reading Man Pages

* Most man pages have specific components:

  * A **summary or synopsis** that shows the structure of the command and important flags and arguments
  * A **longer description** that explains each flag and argument
  * **Examples** of how to use the command in common use-cases
* You can **search for words** with `/`:

  * Example: typing `/reverse` searches for the word *"reverse"* exactly
* If you type `h`, you can see all the **commands you can use to navigate** a man page

---

## Example: `man ls`

The synopsis has some important syntax. For example, `man ls` shows:

```
SYNOPSIS
       ls [OPTION]... [FILE]...
```

* Items within `[ ]` are **optional**. In this case, `ls` can optionally take an `OPTION` or a `FILE`, but neither is required.
* The `...` means that the command takes **one or more** of the preceding item. In this case, `ls` can take one or more options and one or more files.

# Flags and Arguments

Flags are prepended with `-` and change programs’ behavior slightly. For example:

```bash
$ ls -l
```

`-l` is a flag for `ls`. In this case, the `-l` flag for `ls` lists the content of the current directory in **long listing format**.

---

Commands can also take **arguments**. For example:

```bash
$ ls dir1
```

`dir1` is an argument. In this case, this lists the contents of the directory named `dir1`.

---

Commands can take **multiple arguments and flags**. For example:

```bash
$ ls -a -l dir1 dir2
```

This lists the contents of `dir1` and `dir2` in long listing format, showing hidden files (`-a`).

---

Some programs, like `ls`, let you **combine flags** into one `-`:

```bash
$ ls -al dir1 dir2
```
# Advanced Usages of `ls`

The `ls` command has many flags and combinations that can provide detailed information about files and directories.

---

## Sorting and Ordering

* `ls -t` → sort files by modification time, newest first
* `ls -tr` → sort files by modification time, oldest first
* `ls -S` → sort files by file size, largest first
* `ls -Sr` → sort files by file size, smallest first

---

## File Types and Permissions

* `ls -F` → appends indicators (`/` for directories, `*` for executables)
* `ls -lh` → long listing format with human-readable sizes (KB, MB, GB)
* `ls -n` → show user and group IDs instead of names
* `ls -i` → show inode number for each file

---

## Recursion and Depth

* `ls -R` → list subdirectories recursively
* `ls -d */` → list only directories in the current directory
* `ls -lR /path/to/dir` → detailed recursive listing of a directory

---

## Combining Flags

* `ls -lat` → list all files (including hidden), in long format, sorted by modification time
* `ls -lhS` → human-readable long format, sorted by file size
* `ls -al --color=auto` → long format with all files, including hidden, with color highlighting

---

# Directory Commands

| Command | Description                                |
| ------- | ------------------------------------------ |
| `ls`    | List files in working directory            |
| `pwd`   | Print current working directory            |
| `cd`    | Change working directory                   |
| `mkdir` | Make a new directory                       |
| `rmdir` | Remove the given directory (must be empty) |
---

# Relative Directories

| Directory   | Description                                |
| ----------- | ------------------------------------------ |
| `.`         | References the working directory           |
| `..`        | References the parent of working directory |
| `~`         | Refers to the **home** directory           |
---
                              
# File Examination Commands

| Command | Description                                                                                          | Example(s)                            |
| ------- | ---------------------------------------------------------------------------------------------------- | ------------------------------------- |
| `cat`   | “Print” out files to the console                                                                     | `cat file.txt`                        |
| `less`  | Browse a file, with search, scroll, and other features                                               | `less file.txt`                       |
| `more`  | An alternative to `less` with different keybinds and features                                        | `more file.txt`                       |
| `head`  | “Print” out the first 10 lines of a file; use flags to change this behaviour                         | `head file.txt`, `head -n 5 file.txt` |
| `tail`  | “Print” out the last 10 lines of a file; use flags to change this behaviour                          | `tail file.txt`, `tail -n 5 file.txt` |
| `wc`    | “Print” out the number of lines, words, and characters in a file; use flags to change this behaviour | `wc file.txt`, `wc -l file.txt`       |

---

# Searching and Sorting Commands

| Command | Description                                                                                               | Example(s)                                                                                                                                   |
| ------- | --------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------- |
| `grep`  | “Print” out the lines of the input file(s) that contain a specific string                                 | `grep "berry" fruits.txt veggies.txt` → shows the lines in both `fruits.txt` and `veggies.txt` that contain the string "berry"               |
| `sort`  | “Print” out the contents of the input file, but with lines sorted lexicographically                       | `sort file.txt`                                                                                                                              |
| `uniq`  | “Print” out the contents of the input file, but remove (adjacent) repeated lines. Often used with `sort`. | `uniq file.txt`                                                                                                                              |
| `find`  | Searches the filesystem for file(s) that match a pattern                                                  | `find -name "*.java"` → finds all files in the current directory and its subdirectories that end in `.java` (more powerful than `ls *.java`) |

# Standard Streams

Processes (\~ programs) in Unix have **3 standard streams**, which are “abstract” locations that tell a process where to read input from and write output to.

| Stream                       | Java Equivalent | Description                                                               |
| ---------------------------- | --------------- | ------------------------------------------------------------------------- |
| **Standard Input (stdin)**   | `System.in`     | Where the program gets user input; defaults to terminal input             |
| **Standard Output (stdout)** | `System.out`    | Where the program sends “normal” output; defaults to printing to terminal |
| **Standard Error (stderr)**  | `System.err`    | Where the program sends error output; defaults to printing to terminal    |

---

* Many commands will default to using **stdin** for input when some arguments aren’t provided.
  Example: running

  ```bash
  $ grep "a"
  ```

  then typing sentences into your terminal will make `grep` search those lines interactively.

* As a programmer, you usually don’t need to worry about the details— the shell and OS manage them. However, we’ll often **redirect these streams** elsewhere (e.g., sending output to a file or error messages to another location).

# Input and Output Redirection

## `>`: Standard Output Redirection

The `>` operator allows you to execute a command and redirect its **standard output** to the given file, instead of printing it to the console.

Example:

```bash
$ grep "berry" fruits.txt > berries.txt
```

Finds all lines containing `berry` in `fruits.txt`, and writes them to `berries.txt` instead of printing to the console.

* The `>` operator **overwrites** the file.
* The `>>` operator **appends** to a file.

Example:

```bash
$ grep "berry" fruits.txt >> berries.txt
```

---

## `<`: Standard Input Redirection

The `<` operator allows you to use the contents of a file as **standard input**, instead of typing input into the console.

Example:

```bash
$ grep "berry" < fruits.txt
```

Finds lines containing `berry` within `fruits.txt`.

This looks similar to:

```bash
$ grep "berry" fruits.txt
```

But with `<`, `grep` is now reading from **standard input**, not directly from a file. This distinction becomes more important in advanced use cases.

---

## `2>`: Standard Error Redirection

The `2>` operator allows you to redirect a command’s **standard error** to a file, instead of printing it to the console.

Example:

```bash
$ javac HasSomeErrors.java 2> errors.txt
```

Compiles `HasSomeErrors.java`, writing any error output to `errors.txt` instead of the console.

You can redirect output and errors separately:

```bash
$ javac *.java > output.txt 2> errors.txt
```

# Pipes

The `|` operator is called a **pipe**. It is used to “link” two commands together.

Example:

```bash
$ command1 | command2
```

In order, the `|` does the following:

1. Executes `command1`
2. Executes `command2`, using the **standard output** of `command1` as the **standard input** to `command2`

Conceptually, using a pipe is shorthand for the following sequence of commands:

```bash
command1 > filename
command2 < filename
rm filename
```

The pipe operator avoids the need for creating a temporary file, making command chaining more efficient.

# More Command Line Operators

## And (`&&`)

The **and** operator (`&&`) is placed between two commands:

```bash
command1 && command2
```

* If `command1` **succeeds**, it then runs `command2`.
* If `command1` **fails**, then `command2` is **not** run.
* Useful when `command2` depends on `command1` succeeding.
* This behavior comes from [*short-circuiting*](https://en.wikipedia.org/wiki/Short-circuit_evaluation) in Boolean expressions.

Example:

```bash
$ mkdir project && cd project
```

Creates a new directory and enters it only if the directory creation succeeds.

---

## Or (`||`)

The **or** operator (`||`) is placed between two commands:

```bash
command1 || command2
```

* If `command1` **succeeds**, then `command2` is **not** run.
* If `command1` **fails**, it then runs `command2`.
* Useful when `command2` is a fallback for `command1`.
* This behavior also comes from *short-circuiting* in Boolean expressions.

Example:

```bash
$ javac CompilerErrors.java || echo "Compilation failed!"
```

Attempts to compile a file, and if it fails, prints an error message.

---

## Then (`;`)

The **then** operator (`;`) is placed between two commands:

```bash
command1 ; command2
```

* Runs `command1` and then `command2`, **regardless** of whether `command1` succeeded or failed.

Example:

```bash
$ echo "First" ; echo "Second"
```

Outputs both lines sequentially, no matter what happens in the first command.

# `xargs`: Convert stdin to Arguments

We talked about **standard input (stdin)** and **command-line arguments** being different concepts. Frequently, you want to convert standard input to arguments (often as part of chaining many `|` commands). `xargs` is a command that lets you do just that!

---

## Example

```bash
$ ls *.java | xargs javac
```

* `ls *.java` → outputs `.java` filenames to standard output
* `|` → pipes this list to the next command as standard input
* `javac` → needs filenames as arguments, not stdin
* `xargs` → converts the stdin list into command-line arguments for `javac`

This is shorthand for the longer process:

1. `ls *.java > toCompile.txt`
2. `xargs javac < toCompile.txt`
3. `rm toCompile.txt`

---

# `find`: Recursively Search Directories

`ls *.java` only shows files in the current directory. The `find` command searches within **subdirectories** as well.

## Example

```bash
$ find -name "*.java"
```

Finds all `.java` files in the current directory **and all subdirectories**.

You will often pair `find` with `xargs` to perform an operation on all matches:

```bash
$ find -name "*.java" | xargs javac
```

Compiles all Java files in the current directory and its subdirectories.

---

# `cut`: Simplify Complex Strings

The `cut` command extracts specific **characters** or **fields** from text input.

## Using `-c` (characters)

```bash
$ echo "abcdef" | cut -c2
b

$ echo "abcdef" | cut -c2-5
bcde

$ echo "abcdef" | cut -c2,1,4
bad
```

## Using `-d` (delimiter) and `-f` (field)

Split input into fields by a delimiter, then pick specific fields.

Example with CSV:

```bash
$ echo "a,b,c,d,e,f" | cut -d, -f1
a
```

# `awk`: Powerful text processing

## Basic Concepts
`awk` is a powerful text-processing command in Unix/Linux. It is especially useful for working with structured text files, such as CSV or log files. Think of it as a simple programming language that works line by line, splitting text into fields and letting you perform actions on them.


* `awk` reads input **line by line**.
* Each line is split into **fields** (by default, fields are separated by spaces or tabs).
* Fields are accessed with `$1`, `$2`, `$3`, …

  * `$1` = first field
  * `$2` = second field
  * `$0` = the whole line

---

## Examples

### 1. Print a specific column

```bash
$ awk '{print $1}' data.txt
```

Prints the **first field** (column) of every line in `data.txt`.

---

### 2. Print multiple columns

```bash
$ awk '{print $1, $3}' data.txt
```

Prints the **first** and **third** fields from each line.

---

### 3. Use a different delimiter

```bash
$ awk -F, '{print $1, $2}' data.csv
```

`-F,` tells `awk` to use a comma as the field separator. This prints the first and second columns from a CSV file.

---

### 4. Conditional printing

```bash
$ awk '$3 > 50 {print $1, $3}' data.txt
```

Prints the **first** and **third** fields only if the third field is greater than 50.

---

### 5. Summing a column

```bash
$ awk '{sum += $2} END {print "Total:", sum}' sales.txt
```

Adds up all the values in the **second column** of `sales.txt` and prints the total.

---


# `grep`: Searching text patterns

`grep` is used to search for text patterns inside files. It’s like “find” for text. By default, it prints out any line that matches your search.

---

## Basic Concepts

* `grep` looks for patterns in text.
* Patterns can be simple words or powerful **regular expressions**.
* By default, it’s case-sensitive.

---

## Examples

### 1. Search for a word

```bash
$ grep "Alice" data.txt
```

Finds all lines containing `Alice` in `data.txt`.

### 2. Case-insensitive search

```bash
$ grep -i "bob" data.txt
```

Finds lines with `bob` or `Bob`, ignoring case.

### 3. Show line numbers

```bash
$ grep -n "error" logfile.txt
```

Prints matching lines with their line numbers.

### 4. Search recursively in a folder

```bash
$ grep -r "TODO" src/
```

Searches for `TODO` in all files under the `src/` directory.

### 5. Show surrounding context

```bash
$ grep -i -A2 -B2 "error" logfile.txt
```

Shows 2 lines **after** (`-A2`) and **before** (`-B2`) each match.

---

# `sed`: Text editing

`sed` stands for **Stream Editor**. It’s used to automatically edit text in a file or input stream. You can think of it as a “search and replace” tool on steroids.

---

## Basic Concepts

* `sed` applies **editing commands** to text as it streams through.
* The most common use is **find and replace**.
* By default, results are printed to the screen; use `-i` for in-place edits.

---

## Examples

### 1. Simple find and replace

```bash
$ sed 's/green/black/' veggies.txt
```

Replaces the first occurrence of `green` with `black` on each line.

### 2. Replace globally (all matches per line)

```bash
$ sed 's/green/black/g' veggies.txt
```

Replaces all `green` words with `black`.

### 3. In-place editing

```bash
$ sed -i 's/green/black/g' veggies.txt
```

Edits the file directly, changing all `green` to `black`.

### 4. Delete lines

```bash
$ sed '/^#/d' fruits.txt
```

Deletes all lines starting with `#` (comments).

### 5. Print a range of lines

```bash
$ sed -n '5,10p' veggies.txt
```

Prints only lines 5 through 10.

---
