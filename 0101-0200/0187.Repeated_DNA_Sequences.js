//143ms






const findRepeatedDnaSequences = (s, res = []) => {
    if (s.length < 10) return [];

    const DNAmap = { 'A': 1, 'C': 2, 'T': 3, 'G': 4 };
    const B = new Map();

    // Encode the first 10 characters
    let init = '';
    for (let i = 0; i < 10; i++) init += DNAmap[s[i]];
    let window = BigInt(init);

    B.set(window.toString(), [0]);

    // Slide the window across the string
    for (let i = 10; i < s.length; i++) {
        const remove = BigInt(DNAmap[s[i - 10]]) * 1000000000n;
        window = (window - remove) * 10n + BigInt(DNAmap[s[i]]);
        const key = window.toString();

        const temp = B.get(key) ?? [];
        if (temp.length < 2) temp.push(i - 9);
        B.set(key, temp);
    }

    // Collect sequences that appear more than once
    for (const [_, v] of B) {
        if (v.length > 1) res.push(s.slice(v[0], v[0] + 10));
    }

    return res;
};










//18ms








/**
 * @param {string} s
 * @return {string[]}
 */
var findRepeatedDnaSequences = function (s) {
    if (s.length <= 10) return [];

    const all = new Set();
    const repeated = new Set();
    let seq;
    for (let i = 10; i <= s.length; i++) {
        seq = s.slice(i - 10, i);
        if (all.has(seq)) {
            repeated.add(seq);
        } else if (!repeated.has(seq)) {
            all.add(seq);
        }
    }

    return [...repeated];
};





