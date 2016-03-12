package com.client.api.method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import com.client.api.utils.Filter;
import com.client.api.wrappers.Ground;
import com.client.api.wrappers.SceneObject;
import com.client.api.wrappers.SceneObjectTile;
import com.client.api.wrappers.WorldController;



public class SceneObjects {
	private static final Comparator<SceneObject> NEAREST_SORTER = new Comparator<SceneObject>() {

		@Override
		public int compare(SceneObject n1, SceneObject n2) {
			return n1.distanceTo() - n2.distanceTo();
		}

	};

	private static final Filter<SceneObject> ALL_FILTER = new Filter<SceneObject>() {

		@Override
		public boolean accept(SceneObject object) {
			return true;
		}

	};
	public static final SceneObject[] getSceneObjects(Filter<SceneObject> filter) {
		ArrayList<SceneObject> sceneObjects = new ArrayList<SceneObject>();
		for(int x = 0; x < 104; x++) {
			for(int y = 0; y < 104; y++) {
				final SceneObject sceneObjectAtTile = getSceneObjectAtTile(x, y);
				if(sceneObjectAtTile != null && filter.accept(sceneObjectAtTile)) {
					sceneObjects.add(sceneObjectAtTile);
				}
				
			}
		}
		return sceneObjects.toArray(new SceneObject[sceneObjects.size()]);
	}
	

	public static final SceneObject[] getSceneObjects() {
		return getSceneObjects(ALL_FILTER);
	}

	public static final SceneObject[] getNearest(final int... ids) {
		return getNearest(new Filter<SceneObject>() {

			@Override
			public boolean accept(SceneObject object) {
				for(final int id : ids) {
					if(id == object.getId()) {
						return true;
					}
				}
				return false;
			}
			
		});
	}

    public static final SceneObject getClosest(final int... ids) {
    	SceneObject[] nearestObjects = getNearest(new Filter<SceneObject>() {

            @Override
            public boolean accept(SceneObject object) {
                for(final int id : ids) {
                    if(id == object.getId()) {
                        return true;
                    }
                }
                return false;
            }

        });
    	if(nearestObjects == null || nearestObjects.length == 0) {
    		return null;
    	}
    	return nearestObjects[0];
    }

	public static final SceneObject[] getNearest(Filter<SceneObject> filter) {
		final SceneObject[] objects = getSceneObjects(filter);
		Arrays.sort(objects, NEAREST_SORTER);
		return objects;
	}


	public static final SceneObject[] getNearest() {
		return getNearest(ALL_FILTER);
	}
	

	
	
	private static SceneObject getSceneObjectAtTile(int x, int y) {

		final Object ground = Game.getScene();
		WorldController grounds = new WorldController(ground);
		Object groundTile = grounds.getGroundArray()[Game.getPlane()][x][y];
		Ground sceneTile = new Ground(groundTile);
		if(groundTile == null) {
			return null;
		}
		final Object[] interObjects = sceneTile.getInteractiveObjects();
		if (interObjects == null || interObjects.length == 0)
			return null;
		for (int i = 0; i < interObjects.length; i++) {
			if (interObjects[i] != null) {
			
				return new SceneObject(new SceneObjectTile(interObjects[i]));
		}
		}
		return null;

	}

}