package scalaDemo

object predicateTests {

	// 42 + 0
	val case1 = BinOp(
		Const(42),
		Const(0),
		"+"
	)                                         //> case1  : scalaDemo.BinOp = BinOp(Const(42),Const(0),+)
	Optimizer.optimize(case1) == Const(42)    //> res0: Boolean = true

  // 42 - 0
	val case2 = BinOp(
		Const(42),
		Const(0),
		"-"
	)                                         //> case2  : scalaDemo.BinOp = BinOp(Const(42),Const(0),-)
	Optimizer.optimize(case2) == Const(42)    //> res1: Boolean = true
	
  // 42 * 0
	val case3 = BinOp(
		Const(42),
		Const(0),
		"*"
	)                                         //> case3  : scalaDemo.BinOp = BinOp(Const(42),Const(0),*)
	Optimizer.optimize(case3) == Const(0)     //> res2: Boolean = true
	
  // 42 / 1
	val case4 = BinOp(
		Const(42),
		Const(1),
		"/"
	)                                         //> case4  : scalaDemo.BinOp = BinOp(Const(42),Const(1),/)
	Optimizer.optimize(case4) == Const(42)    //> res3: Boolean = true
	
	  // !(true && false)
	val case5 = Not(And(
		Bool(true),
		Bool(false))
	)                                         //> case5  : scalaDemo.Not = Not(And(Bool(true),Bool(false)))
	
	Optimizer.optimize(case5)                 //> res4: scalaDemo.Predicate = Or(Bool(false),Bool(true))
}