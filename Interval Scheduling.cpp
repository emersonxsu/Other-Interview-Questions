// sort by start time, and compare previous start with next end time. 
bool attendAll(vector<pair<int,int>> meetings) {
	sort(meetings.begin(), meetings.end(), [&](pair<int,int> p1, pair<int,int> p2){
		return p1.first < p2.first;
	});
	for(size_t i = 1; i <meetings.size(); ++i) {
		if(meetings[i].first < meetings[i-1].second) return false;
	}
	return true;
}

// make start time positive and end time negatie, sort with their abs valus.
// if sorted array has postive, number of rooms++, else --
int minRooms(vector<Interval>& meetings) {
	vector<int> times;
	for(auto m : meetings) {
		times.push_back(m.begin);
		times.push_back(-m.end); 
	}
	sort(times.begin(), times.end(), [](int a, int b){
		return abs(a) == abs(b) ? a < b : abs(a) < abs(b);
	});
	int res = 0, cur = 0;	// cur is the number of rooms need currently
	for(auto t : times) {
		if(t >= 0) res = max(res, ++cur);
		else --cur;
	}
	return res;
}