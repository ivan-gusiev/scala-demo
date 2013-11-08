package scalaDemo

object predicateTests {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(108); 

	// 42 + 0
	val case1 = BinOp(
		Const(42),
		Const(0),
		"+"
	);System.out.println("""case1  : scalaDemo.BinOp = """ + $show(case1 ));$skip(40); val res$0 = 
	Optimizer.optimize(case1) == Const(42);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(67); 

  // 42 - 0
	val case2 = BinOp(
		Const(42),
		Const(0),
		"-"
	);System.out.println("""case2  : scalaDemo.BinOp = """ + $show(case2 ));$skip(40); val res$1 = 
	Optimizer.optimize(case2) == Const(42);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(68); 
	
  // 42 * 0
	val case3 = BinOp(
		Const(42),
		Const(0),
		"*"
	);System.out.println("""case3  : scalaDemo.BinOp = """ + $show(case3 ));$skip(39); val res$2 = 
	Optimizer.optimize(case3) == Const(0);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(68); 
	
  // 42 / 1
	val case4 = BinOp(
		Const(42),
		Const(1),
		"/"
	);System.out.println("""case4  : scalaDemo.BinOp = """ + $show(case4 ));$skip(40); val res$3 = 
	Optimizer.optimize(case4) == Const(42);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(79); 
	
	  // !(true && false)
	val case5 = Not(And(
		Bool(true),
		Bool(false))
	);System.out.println("""case5  : scalaDemo.Not = """ + $show(case5 ));$skip(29); val res$4 = 
	
	Optimizer.optimize(case5);System.out.println("""res4: scalaDemo.Predicate = """ + $show(res$4))}
}
