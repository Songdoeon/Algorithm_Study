#include <bits/stdc++.h>
#define ll long long int
#define endl '\n'
#define INF 1e9 + 7;
using namespace std;

ll n, m, res;
ll tree[8000];
pair<ll, ll> arr[2000000];

void update(ll N, ll s, ll e, ll idx, ll val) {
	if (idx > e || idx < s)
		return;
	if (s == e) {
		if (idx == s)
			tree[N] += 1;
		return;
	}
	ll mid = (s + e) / 2;
	update(N * 2, s, mid, idx, val);
	update(N * 2 + 1, mid + 1, e, idx, val);
	tree[N] = tree[N * 2] + tree[N * 2 + 1];
}

ll query(ll N, ll s, ll e, ll l, ll r) {
	if (l > e || r < s)
		return 0;
	if (l <= s && e <= r)
		return tree[N];
	ll mid = (s + e) / 2;
	return query(N * 2, s, mid, l, r) + query(N * 2 + 1, mid + 1, e, l, r);
}

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL);

	cin >> n >> m;

	for (ll i = 0; i < m; i++)
		cin >> arr[i].first >> arr[i].second;

	sort(arr, arr + m);

	for (ll i = 0; i < m; i++) {
		res += query(1, 0, n - 1, arr[i].second, n - 1);
		update(1, 0, n - 1, arr[i].second - 1, 1);
	}

	cout << res << endl;

	return 0;
}