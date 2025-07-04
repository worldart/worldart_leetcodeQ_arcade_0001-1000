//0ms





use std::ops::{Add, Sub, Mul, Div};

impl Solution {
    pub fn eval_rpn(tokens: Vec<String>) -> i32 {
        let mut stack = vec![];

        let binary_op = |f: fn(_, _) -> _, stack: &mut Vec<_>| {
            let (o2, o1) = (stack.pop().unwrap(), stack.pop().unwrap());
            stack.push(f(o1, o2))
        };

        for token in tokens {
            match token.as_str() {
                "+" => binary_op(i32::add, &mut stack),
                "-" => binary_op(i32::sub, &mut stack),
                "*" => binary_op(i32::mul, &mut stack),
                "/" => binary_op(i32::div, &mut stack),
                number => stack.push(number.parse().unwrap()),
            }
        }
        stack.pop().unwrap()
    }
}





//2ms





impl Solution {
    pub fn eval_rpn(tokens: Vec<String>) -> i32 {
        let mut stack: Vec<i32> = Vec::new();
        for token in tokens {
            if token == "+" {
                let b = stack.pop().unwrap();
                let a = stack.pop().unwrap();
                stack.push(a + b);
            } else if token == "-" {
                let b = stack.pop().unwrap();
                let a = stack.pop().unwrap();
                stack.push(a - b);
            } else if token == "/" {
                let b = stack.pop().unwrap();
                let a = stack.pop().unwrap();
                stack.push(a / b);
            } else if token == "*" {
                let b = stack.pop().unwrap();
                let a = stack.pop().unwrap();
                stack.push(a * b);
            } else {    
                stack.push(token.parse::<i32>().unwrap());
            }
        }

        stack.pop().unwrap()
    }
    
}





//0ms







const ERR_MSG: &'static str = "Guaranteed by the constraints";

impl Solution {
    pub fn eval_rpn(tokens: Vec<String>) -> i32 {
        let mut stack: Vec<i32> = vec![];

        for token in tokens {
            if matches!(token.as_ref(), "+" | "-" | "*" | "/") {
                let b = stack.pop().expect(ERR_MSG);
                let a = stack.pop().expect(ERR_MSG);

                let val = match token.as_ref() {
                    "+" => a + b,
                    "-" => a - b,
                    "*" => a * b,
                    "/" => a / b,
                    _ => panic!(),
                };
                stack.push(val);
            } else {
                stack.push(token.parse().expect(ERR_MSG));
            }
        }

        stack.pop().unwrap()
    }
}
