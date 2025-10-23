//15ms






use std::collections::HashSet;

impl Solution {
  pub fn find_repeated_dna_sequences(s: String) -> Vec<String> {
    // brute force with early stops?
    // store
    let mut res: HashSet<String> = HashSet::new();
    let mut hs: HashSet<String> = HashSet::new();
    let n = s.len();
    if n < 10 { return vec![] }
    for i in 0..=(n-10) {
      let substr = s[i..(i+10)].to_string();
      if hs.contains(&substr) { res.insert(substr.clone()); }
      hs.insert(substr);
    }
    let resv: Vec<String> = res.into_iter().collect();
    resv
  }
}






//261ms






use std::collections::{HashMap, HashSet};

impl Solution {

    pub fn find_repeated_dna_sequences(s: String) -> Vec<String> {
        if s.is_empty() {
            return Vec::new();
        }

        let m = 10u64;
        let n = s.len() as u64;

        if n < m {
            return Vec::new();
        }

        // 1. Get unique characters
        let unique_chars: HashSet<char> = s.chars().collect();
        let mut unique_vec: Vec<char> = unique_chars.into_iter().collect();

        // Sort
        unique_vec.sort();

        // 2. Determine how many bits are needed for encoding
        // let bits = (unique_vec.len() as f64).log2().ceil() as u64;
        // Can be directly set to 2
        let bits = 2;

        // 3. Assign encoding
        let mut encode_map: HashMap<char, u32> = HashMap::new();
        for (i, c) in unique_vec.iter().enumerate() {
            encode_map.insert(*c, i as u32); // Store numbers, will be converted to binary like 01, 10, 11 in memory
        }

        // 3. Build rolling hash (bit encoding) `bitmask = (1 << (m * 4) - 1`, where `m` is the pattern length
        let bitmask = (1 << (bits * m)) - 1;

        // 4. Initialize `hash = 0`, iterate `i` from `0 to n - m` (n is text length, m is pattern length), take `text[i..i+m)`, and compute hash for each character
        let texts: Vec<char> = s.chars().collect();

        // Multiple strings may have the same hash
        let mut seen = vec![0u64; 1 << 20]; // 1M space, 0=not seen, 1=seen once, 2=added to results
        let mut results: HashSet<String> = HashSet::new();

        // Get hash for the first window
        let mut hash = 0u64;
        for i in 0..m as usize {
            // Compute hash: ((hash << 2) | new_char_code) & bitmask
            let new_char_code = *encode_map.get(&texts[i]).unwrap_or(&0) as u64;
            hash = ((hash << bits) | new_char_code) & bitmask
        }

        seen[hash as usize] = 1;

        for i in 1..=(n - m) as usize {
            // Compute hash: ((hash << 2) | new_char_code) & bitmask
            let new_char_code = *encode_map.get(&texts[i + (m - 1) as usize]).unwrap_or(&0) as u64;
            hash = (hash << bits | new_char_code) & bitmask;

            // Check if text exists in seen
            match seen[hash as usize] {
                0 => {
                    seen[hash as usize] = 1;
                }
                1 => {
                    results.insert(s[i..i + m as usize].to_string());
                    seen[hash as usize] = 2; // Recorded
                }
                2 => {
                    // Already added to results, ignore
                }
                _ => {}
            }
        }

        results.into_iter().collect()
    }
}





//3ms






use std::collections::HashMap;

impl Solution {
    pub fn find_repeated_dna_sequences(s: String) -> Vec<String> {
        if s.len() < 10 {
            return vec![];
        }

        // A 00
        // C 01
        // G 10
        // T 11
        const mask: u32 = 0b_00000000_00001111_11111111_11111111;

        let mut seen: HashMap<u32, bool> = HashMap::new();
        let mut curr = 0u32;
        let mut iter = s.into_bytes().into_iter();

        for _ in 0..10 {
            curr <<= 2;
            curr |= encode(iter.next().unwrap());
        }

        seen.insert(curr, false);

        while let Some(byte) = iter.next() {
            curr <<= 2;
            curr &= mask;
            curr |= encode(byte);

            seen.entry(curr)
                .and_modify(|repeated| { *repeated = true })
                .or_insert(false);
        }

        seen.into_iter()
            .filter(|(_, repeated)| *repeated)
            .map(|(key, _)| decode(key))
            .collect()
    }
}

fn encode(b: u8) -> u32 {
    match b {
        b'A' => 0b00,
        b'C' => 0b01,
        b'G' => 0b10,
        b'T' => 0b11,
        b => unreachable!(),
    }
}

fn decode(key: u32) -> String {
    let mut s = String::with_capacity(10);
    let mut mask   = 0b_00000000_00001100_00000000_00000000u32;
    let mut shifts = 18;

    for _ in 0..10 {
        let c = match (key & mask) >> shifts {
            0b00 => 'A',
            0b01 => 'C',
            0b10 => 'G',
            0b11 => 'T',
            b => unreachable!(),
        };

        s.push(c);

        mask >>= 2;
        shifts -= 2;
    }

    s
}







//1ms







use std::collections::HashMap;

struct SeenSet {
    storage: Box<[u32; 65536]>,
}

impl SeenSet {
    fn new() -> Self {
        Self { storage: vec![0; 65536].into_boxed_slice().try_into().unwrap() }
    }

    fn mark(&mut self, key: u32) -> bool {
        let upper = key >> 16 as usize;
        let lower = key as u16 as usize;

        let storage = &mut self.storage[lower];
        let shifts = upper << 1; // upper = 0-15, x2 = right shifts

        let mut extracted = (*storage >> shifts) & 0b11;
        let mut emit = false;

        if extracted == 0 {
            extracted = 1;
        } else if extracted == 1 {
            extracted = 2;
            emit = true;
        } else {
            return false;
        }

        let mut current = *storage;
        current &= !(0b11 << shifts);
        current |= (extracted << shifts);

        *storage = current;

        return emit;
    }
}

impl Solution {
    pub fn find_repeated_dna_sequences(s: String) -> Vec<String> {
        if s.len() <= 10 {
            return vec![];
        }

        // A 00
        // C 01
        // G 10
        // T 11
        const mask: u32 = 0b_00000000_00001111_11111111_11111111;

        let mut out = Vec::new();
        let mut seen = SeenSet::new();
        let mut curr = 0u32;
        let mut bytes = s.as_bytes().into_iter();
        let mut strings = s.as_bytes().windows(10);

        for _ in 0..10 {
            curr <<= 2;
            curr |= encode(*bytes.next().unwrap());
        }

        seen.mark(curr);
        strings.next();

        while let (Some(&byte), Some(slice)) = (bytes.next(), strings.next()) {
            curr <<= 2;
            curr &= mask;
            curr |= encode(byte);

            if seen.mark(curr) {
                out.push(unsafe { String::from_utf8_unchecked(slice.to_vec()) });
            }
        }

        out
    }
}

fn encode(b: u8) -> u32 {
    match b {
        b'A' => 0b00,
        b'C' => 0b01,
        b'G' => 0b10,
        b'T' => 0b11,
        b => unreachable!(),
    }
}
