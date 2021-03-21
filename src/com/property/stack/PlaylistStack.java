package com.property.stack;

import java.util.Stack;
import com.property.model.Playlist;

public class PlaylistStack {
    public Stack<Playlist> playlists = new Stack<Playlist>();

    // find playlist
    public Playlist findPlaylist(String keyword) {
        for(int i = 0; i < this.playlists.size(); i++)  {
            Playlist currentPlaylist = this.playlists.get(i);
            currentPlaylist.id = i;
            try {
                if(currentPlaylist.title.toLowerCase().equals(keyword.toLowerCase())
                        || currentPlaylist.owner.toLowerCase().equals(keyword.toLowerCase())
                        || (Integer.parseInt(keyword) - 1) == i) {
                    return currentPlaylist;
                }
            } catch(Exception e) {}
        }
        return null;
    }

    // add playlist
    public boolean setPlaylist(String title, String owner) {
        try {
            playlists.push(new Playlist(title, owner));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    // add playlist to index
    // new index will start from 1
    public boolean setPlaylist(String title, String owner, int index) {
        try {
            playlists.add(index, new Playlist(title, owner));
            return true;
        } catch(Exception e) {
            return false;
        }
    }
    // remove last property
    public boolean deletePlaylist() {
        try {
            playlists.remove(0);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
    // remove custom index
    public boolean deletePlaylist(int index) {
        try {
            playlists.remove(index);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
    // remove all
    public boolean deletePlaylist(boolean removeAll) {
        try {
            playlists.clear();
            return true;
        } catch(Exception e) {
            return false;
        }
    }


}
