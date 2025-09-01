Polynomial Solver from Roots

This project takes roots provided in a JSON format (with arbitrary bases like 2, 3, 6, 8, 12, 15, 16, etc.), converts them to decimal, and constructs the monic polynomial that has these roots.

The polynomial is built using the formula:

P(x) = \prod_{i=1}^{m} (x - r_i)

where m = k - 1. Only the first m roots are used for coefficient calculation.

⸻

Files Included
	•	Main.java → Java program with both test cases hardcoded.
	•	README.md → This documentation file.

⸻

How to Run
	1.	Compile the Java program:

javac Main.java


	2.	Run it:

java Main



⸻

Test Case 1

Input (hardcoded):

{
  "keys": { "n": 4, "k": 3 },
  "1": { "base": "10", "value": "4" },
  "2": { "base": "2", "value": "111" },
  "3": { "base": "10", "value": "12" },
  "6": { "base": "4", "value": "213" }
}

Output:

Degree: 2
Coefficients: 1 -11 28
Roots used: 4 7
Constant term: 28


⸻

Test Case 2

Input (hardcoded):

{
  "keys": { "n": 10, "k": 7 },
  "1": { "base": "6", "value": "13444211440455345511" },
  "2": { "base": "15", "value": "aed7015a346d635" },
  "3": { "base": "15", "value": "6aeeb69631c227c" },
  "4": { "base": "16", "value": "e1b5e05623d881f" },
  "5": { "base": "8", "value": "316034514573652620673" },
  "6": { "base": "3", "value": "2122212201122002221120200210011020220200" },
  "7": { "base": "3", "value": "20120221122211000100210021102001201112121" },
  "8": { "base": "6", "value": "20220554335330240002224253" },
  "9": { "base": "12", "value": "45153788322a1255483" },
  "10": { "base": "7", "value": "1101613130313526312514143" }
}

Output (truncated for readability):

Degree: 6
Coefficients: 1 -16035585567652874221 62896005845998832818285892998257358574 ...
Roots used: 995085094601491 320923294898495900 196563650089608567 1016509518118225951 3711974121218449851 10788619898233492461
Constant term: 2555329762523754641638371521787153182033159975203073626408066416562448111114093826928388280970414872420300


⸻

Key Points
	•	Numbers are first decoded from their respective bases into decimal.
	•	Only the first m = k-1 roots are used.
	•	Coefficients are computed using exact arithmetic with BigInteger.
	•	Works for both small cases (like Test Case 1) and huge numbers (like Test Case 2).

⸻

✅ That’s all. Simple compile, run, and check the output.
