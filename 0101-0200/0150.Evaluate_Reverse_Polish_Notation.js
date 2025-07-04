//4ms





/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function(tokens) {
    let stack = [];

    for (let c of tokens) {
        if (c === "+") {
            stack.push(stack.pop() + stack.pop());
        } else if (c === "-") {
            let second = stack.pop();
            let first = stack.pop();
            stack.push(first - second);
        } else if (c === "*") {
            stack.push(stack.pop() * stack.pop());
        } else if (c === "/") {
            let second = stack.pop();
            let first = stack.pop();
            stack.push(parseInt(first / second));
        } else {
            stack.push(parseInt(c));
        }
    }

    return stack[0];    
};






//8ms







/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function(tokens) {
    const stack=[]
    tokens.forEach(token=>{
        if (token=='+') {
            stack.push(stack.pop()+stack.pop())
        }
        else if (token=='*') {
            stack.push(stack.pop()*stack.pop())
        }    
        else if (token=='-') {
            const num1=stack.pop()
            const num2=stack.pop()
            stack.push(num2-num1)
        }   
        else if (token=='/') {
            const num1=stack.pop()
            const num2=stack.pop()
            const sign = num1*num2>0?1:-1
            stack.push(Math.floor(Math.abs(num2)/Math.abs(num1))*sign)
        } 
        else {
            stack.push(parseInt(token))
        }   
        //console.log(stack[stack.length-1])
    })
    return stack.pop()
};
