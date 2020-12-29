todo: todo.o
	java Todo

todo.o:
	javac Todo.java

test: todo install
	yarn run test

clean:
	rm -f *.lock
	rm -f package-lock.json
	rm -f *.class
	rm -f *.txt
	rm -rf node_modules

install:
	yarn install
