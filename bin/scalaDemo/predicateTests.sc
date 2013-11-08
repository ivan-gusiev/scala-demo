package scalaDemo

object predicateTests {

	// 42 + 0
	val case1 = BinOp(
		Const(42),
		Const(0),
		"+"
	)                                         //> case1  : scalaDemo.BinOp = BinOp(Const(42),Const(0),+)
	Optimizer.optimize(case1) == Const(42)    //> scala.NotImplementedError: an implementation is missing
                                                  //| 	at scala.Predef$.$qmark$qmark$qmark(Predef.scala:252)
                                                  //| 	at scalaDemo.Optimizer$.optimize(Predicate.scala:17)
                                                  //| 	at scalaDemo.predicateTests$$anonfun$main$1.apply$mcV$sp(scalaDemo.predi
                                                  //| cateTests.scala:11)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at scalaDemo.predicateTests$.main(scalaDemo.predicateTests.scala:3)
                                                  //| 	at scalaDemo.predicateTests.main(scalaDemo.predicateTests.scala)

  // 42 - 0
	val case2 = BinOp(
		Const(42),
		Const(0),
		"-"
	)
	Optimizer.optimize(case2) == Const(42)
	
  // 42 * 0
	val case3 = BinOp(
		Const(42),
		Const(0),
		"*"
	)
	Optimizer.optimize(case3) == Const(0)
	
  // 42 / 1
	val case4 = BinOp(
		Const(42),
		Const(1),
		"/"
	)
	Optimizer.optimize(case4) == Const(42)
	
	  // !(true && false)
	val case5 = Not(And(
		Bool(true),
		Bool(false))
	)
	
	Optimizer.optimize(case5)
}