package act_2

object newOne {
  val Upper='A' to 'Z'
  val Lower='a' to 'z'
  
  def encode(text:String, key:Int)=text.map{
    case c if Upper.contains(c) => process(Upper, c, key)
    case c if Lower.contains(c) => process(Lower, c, key)
    case c => c
  }
  
  def decode(text:String, key:Int)={
    encode(text,-key)
  }
  
  def process(a:IndexedSeq[Char], c:Char, key:Int)={
    a((c - a.head + key + a.size)%a.size)
  }

  def main(args:Array[String]){
    
    print("Text: ")
    var text:String = scala.io.StdIn.readLine()
    print("Shift: ")
    var shift:Int = scala.io.StdIn.readInt()
    
    var encoded = encode(text, shift)
    println("Ciphertext : " + encoded)
    println("Decrypted  : " + decode(encoded, shift))
    
//    val text="IMAL KOVINDA"
//    val shift = 4
//    println("Text  : " + text)
//    val encoded=encode(text, shift)
//    println("Ciphertext : " + encoded)
//    println("After Decrypted  : " + decode(encoded, shift))
  }
}