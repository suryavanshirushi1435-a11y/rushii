int countStudents(int* s, int n, int* w, int m) {
    int c[2] = {0};

    for(int i = 0; i < n; i++) c[s[i]]++;

    for(int i = 0; i < m && c[w[i]]; i++)
        c[w[i]]--;

    return c[0] + c[1];
}