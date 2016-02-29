package com.javajiale.goalapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class today_goal_fragment extends Fragment{
	private ListView listView;
	private String[] listViewContent = {"ListView1","ListView2","ListView3","ListView4","ListView5",
			"ListView6","ListView7","ListView8","ListView9","ListView10"};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_todayGoal, null);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		listView = (ListView) getActivity().findViewById(R.id.listView);
		listView.setAdapter(new ListAdapter());
		//        listView.setOnItemLongClickListener(new OnItemLongClickListener() {
//
//          public boolean onItemLongClick(AdapterView<?> arg0, View v,
//                  int position, long arg3) {
//              Toast.makeText(ListViewTestActivity.this, "content"+position, Toast.LENGTH_LONG).show();
//              return false;
//          }
//      });
		registerForContextMenu(listView);
	}
	class ListAdapter extends BaseAdapter {

		public int getCount() {
			return listViewContent.length;
		}

		public Object getItem(int position) {
			return listViewContent[position];
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if(convertView == null){
				convertView = new TextView(getActivity());
			}
			((TextView)convertView).setText(listViewContent[position]);
			return convertView;
		}
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
									ContextMenu.ContextMenuInfo menuInfo) {
		menu.setHeaderTitle("人物简介");
		//添加菜单项
		menu.add(0,Menu.FIRST,0,"特长");
		menu.add(0,Menu.FIRST+1,0,"战斗力");
		menu.add(0,Menu.FIRST+2,0,"经典语录");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
		Toast.makeText(getActivity(), "content" + item.getItemId() + info.position, Toast.LENGTH_LONG).show();
		return super.onContextItemSelected(item);
	}
}

