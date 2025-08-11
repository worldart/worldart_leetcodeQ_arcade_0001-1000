//0ms






/**
 * @param {number} numerator
 * @param {number} denominator
 * @return {string}
 */
var fractionToDecimal = function(numerator, denominator) {
    if (numerator === 0) return "0";
    let res = "";
    if (Math.sign(numerator) !== Math.sign(denominator)) res += "-";

    let num = Math.abs(numerator);
    let den = Math.abs(denominator);
    res += Math.floor(num / den);
    num %= den;
    if (num === 0) return res;

    res += ".";
    const map = new Map();

    while (num !== 0) {
        if (map.has(num)) {
            const idx = map.get(num);
            return res.slice(0, idx) + "(" + res.slice(idx) + ")";
        }
        map.set(num, res.length);
        num *= 10;
        res += Math.floor(num / den);
        num %= den;
    }

    return res;
};






//1ms






/**
 * @param {number} numerator
 * @param {number} denominator
 * @return {string}
 */
var fractionToDecimal = function(numerator, denominator) {
    if (numerator === 0) {
        return "0";
    }

    const isNegative = (numerator < 0) !== (denominator < 0);
    
    numerator = Math.abs(numerator);
    denominator = Math.abs(denominator);

    let digit = Math.floor(numerator / denominator);
    let result = digit.toString();
    let decimal = [];
    let remainder = numerator % denominator;
    let count = 10000;
    let decimalMap = new Map();
    let i = 0;
    let decimalRepeatIndex = -1;

    numerator = remainder * 10;

    while (numerator) {
        digit = Math.floor(numerator / denominator)
        remainder = numerator % denominator;
        const mapKey = `${remainder},${digit}`;

        if (decimalMap.has(mapKey)) {
            decimalRepeatIndex = decimalMap.get(mapKey);

            break;
        }

        decimal.push(digit);
        numerator = remainder * 10;
        decimalMap.set(mapKey, i);
        i++;

        if (!count--) {
            break;
        }
    }
    
    if (decimal.length) {
        result += ".";
        const index = decimalRepeatIndex !== -1 ? decimalRepeatIndex : decimal.length;
        let repeatingDecimals = "";

        for (let j = 0; j < index; j++) {
            result += decimal[j];
        }

        for (let j = index; j < decimal.length; j++) {
            repeatingDecimals += decimal[j];
        }

        if (repeatingDecimals) {
            result += "(" + repeatingDecimals + ")";
        }
    } 

    return isNegative ? "-" + result : result;
};






//1ms







/**
 * @param {number} numerator
 * @param {number} denominator
 * @return {string}
 */
var fractionToDecimal = function(numerator, denominator) {
    // check for repeating digits
    const map = new Map();

    let result = '';

    const sign = Math.sign(numerator) * Math.sign(denominator)
    if (sign < 0) result += '-';

    const den = Math.abs(denominator);
    let num = Math.abs(numerator);

    // get digits before decimal
    result += Math.floor(num / den);
    num %= den;
    if (num > 0) result += '.';
    num *= 10;

    // get digits after decimal + check for repeat
    while (num > 0) {
        let digit = Math.floor(num / den);
        if (map.has(num)) {
            const idx = map.get(num);
            result = `${result.slice(0, idx)}(${result.slice(idx)})`;
            num = 0;
        } else {
            map.set(num, result.length);
            result += digit;
            num %= den;
            num *= 10;
        }
    }
    return result;
};

