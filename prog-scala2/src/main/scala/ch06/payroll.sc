case class Employee (
    name: String,
    title: String,
    annualSalary: Double,
    taxRate: Double,
    insurancePremiumsPerWeek: Double)

val employee = List (
  Employee("Buck Trends", "CEO", 200000, 0.25, 100.0),
  Employee("Cindy Banks", "CFO", 170000, 0.22, 120.0),
  Employee("Joe Coder", "Developer", 130000, 0.20, 120.0)
)

val netPay = employee map { e =>
  val net = (1.0 - e.taxRate)*(e.annualSalary/52.0) -
      e.insurancePremiumsPerWeek

  (e, net)
}

println("** Paychecks:")
netPay foreach {
  case (e, net) =>
    println(f"  ${e.name+':'}%-16s ${net}%10.2f")
}

val report = (netPay foldLeft(0.0,0.0,0.0)) {
  case ((totalSalary, totalNet, totalInsurance), (e,net)) =>
    (totalSalary + e.annualSalary/52.0,
      totalNet + net,
      totalInsurance + e.insurancePremiumsPerWeek)
}

println("\n** Report:")
val (r1,r2,r3) = report
println(f"  Total Salary:    ${r1}%10.2f")
println(f"  Total Net:       ${r2}%10.2f")
println(f"  Total Insurance: ${r3}%10.2f")
