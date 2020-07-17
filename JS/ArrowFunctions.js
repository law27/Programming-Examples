
let ask = (question , yes, no) => {
	if(confirm(question)) yes()
	else no()
}

ask (
	"Do You Agree?",
	() => alert("You agreed."),
	() => alert("You canceled")
	);

// Call-back Functions

/*function ask(question, yes, no) {
  if (confirm(question)) yes()
  else no();
}

ask(
  "Do you agree?",
  function() { alert("You agreed."); },
  function() { alert("You canceled the execution."); }
);*/