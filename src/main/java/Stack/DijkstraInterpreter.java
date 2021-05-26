package Stack;

public class DijkstraInterpreter {
    private StackUsingArrays<Double> operands;
    private StackUsingArrays<String> operators;

    public DijkstraInterpreter() {
        operands = new StackUsingArrays<>();
        operators = new StackUsingArrays<>();
    }

    public Double evalutate(String expression) {

       String[] tokens = expression.split(" ");
        for (String token:tokens) {
            switch (token) {
                case "(":
                    operators.push(token);
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    if (!operators.isEmpty() && hasPrecedence(token, operators.peek())) {
                        operands.push(doOperation(operands.pop(), operands.pop(), operators.pop()));
                    }
                    operators.push(token);
                    break;
                case ")":
                    while (!operators.peek().equalsIgnoreCase("(")) {
                        operands.push(doOperation(operands.pop(), operands.pop(), operators.pop()));
                    }
                    operators.pop();
                    break;
                default:
                    double value;
                    try{
                        value = Double.parseDouble(token);
                        operands.push(value);
                    }
                    catch (NumberFormatException e){
                        System.out.println("entered invaild number " +token+" in expression");
                        throw e;
                    }
            }
        }
        while(!operators.isEmpty()) {
            operands.push(doOperation(operands.pop(),operands.pop(),operators.pop()));
        }

        return operands.pop();
    }

    private Double doOperation(Double operand1, Double operand2, String operation) {
        switch (operation) {
            case "+":
                return operand2 + operand1;
            case "-":
                return operand2 - operand1;
            case "*":
                return operand2 * operand1;
            case "/":
                return operand2 / operand1; //we can handle divide by zero exception if required
            default:
                return 0.0;
        }

    }

    private boolean hasPrecedence(String operator1, String operator2) {
        if (operator1.equalsIgnoreCase("(" )|| operator2.equalsIgnoreCase(")")) {
            return false;
        }
        return (operator1.equalsIgnoreCase("+") || operator1.equalsIgnoreCase("-"))
                && (operator2.equalsIgnoreCase("*") || operator2.equalsIgnoreCase("/"));
    }
}
