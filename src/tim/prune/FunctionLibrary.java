package tim.prune;

import tim.prune.correlate.AudioCorrelator;
import tim.prune.correlate.PhotoCorrelator;
import tim.prune.function.AboutScreen;
import tim.prune.function.AddAltitudeOffset;
import tim.prune.function.AddTimeOffset;
import tim.prune.function.CheckVersionScreen;
import tim.prune.function.ConnectToPointFunction;
import tim.prune.function.ConvertNamesToTimes;
import tim.prune.function.CreateMarkerWaypointsFunction;
import tim.prune.function.CropToSelection;
import tim.prune.function.DeleteFieldValues;
import tim.prune.function.DeleteSelectedRangeFunction;
import tim.prune.function.DisconnectAudioFunction;
import tim.prune.function.DisconnectPhotoFunction;
import tim.prune.function.DiskCacheConfig;
import tim.prune.function.DownloadOsmFunction;
import tim.prune.function.DuplicatePoint;
import tim.prune.function.FindWaypoint;
import tim.prune.function.GetWikipediaFunction;
import tim.prune.function.HelpScreen;
import tim.prune.function.IgnoreExifThumb;
import tim.prune.function.InterpolateFunction;
import tim.prune.function.PhotoPopupFunction;
import tim.prune.function.PlayAudioFunction;
import tim.prune.function.ProjectCircle;
import tim.prune.function.ProjectPoint;
import tim.prune.function.RearrangePhotosFunction;
import tim.prune.function.RearrangeWaypointsFunction;
import tim.prune.function.RemoveAudioFunction;
import tim.prune.function.RemovePhotoFunction;
import tim.prune.function.RotatePhoto;
import tim.prune.function.SearchOsmPoisFunction;
import tim.prune.function.SearchWikipediaNames;
import tim.prune.function.SelectSegmentFunction;
import tim.prune.function.SelectTimezoneFunction;
import tim.prune.function.ShowFullDetails;
import tim.prune.function.ShowKeysScreen;
import tim.prune.function.ShowThreeDFunction;
import tim.prune.function.SingleNumericParameterFunction;
import tim.prune.function.StopAudioFunction;
import tim.prune.function.autoplay.AutoplayFunction;
import tim.prune.function.charts.Charter;
import tim.prune.function.compress.CompressTrackFunction;
import tim.prune.function.compress.DeleteMarkedPointsFunction;
import tim.prune.function.compress.MarkLiftsFunction;
import tim.prune.function.compress.MarkPointsInRectangleFunction;
import tim.prune.function.deletebydate.DeleteByDateFunction;
import tim.prune.function.distance.DistanceFunction;
import tim.prune.function.edit.PointNameEditor;
import tim.prune.function.edit.TruncatePointCoords;
import tim.prune.function.estimate.EstimateTime;
import tim.prune.function.estimate.LearnParameters;
import tim.prune.function.settings.*;
import tim.prune.function.sew.SewTrackSegmentsFunction;
import tim.prune.function.sew.SplitSegmentsFunction;
import tim.prune.function.srtm.LookupSrtmFunction;
import tim.prune.function.weather.GetWeatherForecastFunction;
import tim.prune.load.AudioLoader;
import tim.prune.load.BabelLoadFromFile;
import tim.prune.load.BabelLoadFromGps;
import tim.prune.save.GpsSaver;
import tim.prune.save.GpxExporter;
import tim.prune.save.ImageExporter;
import tim.prune.save.KmlExporter;
import tim.prune.save.PovExporter;


/**
 * Class to provide access to functions
 */
public abstract class FunctionLibrary
{
	public static GenericFunction FUNCTION_GPXEXPORT = null;
	public static GenericFunction FUNCTION_KMLEXPORT = null;
	public static PovExporter FUNCTION_POVEXPORT     = null;
	public static GenericFunction FUNCTION_IMAGEEXPORT = null;
	public static GenericFunction FUNCTION_GPSLOAD  = null;
	public static GenericFunction FUNCTION_GPSSAVE  = null;
	public static GenericFunction FUNCTION_IMPORTBABEL = null;
	public static GenericFunction FUNCTION_SAVECONFIG  = null;
	public static GenericFunction FUNCTION_EDIT_WAYPOINT_NAME = null;
	public static GenericFunction FUNCTION_PROJECT_POINT = null;
	public static GenericFunction FUNCTION_PROJECT_CIRCLE = null;
	public static GenericFunction FUNCTION_REARRANGE_WAYPOINTS = null;
	public static GenericFunction FUNCTION_SELECT_SEGMENT = null;
	public static GenericFunction FUNCTION_SPLIT_SEGMENTS = null;
	public static GenericFunction FUNCTION_SEW_SEGMENTS = null;
	public static GenericFunction FUNCTION_CREATE_MARKER_WAYPOINTS = null;
	public static GenericFunction FUNCTION_REARRANGE_PHOTOS = null;
	public static GenericFunction FUNCTION_COMPRESS = null;
	public static GenericFunction FUNCTION_MARK_LIFTS = null;
	public static DeleteMarkedPointsFunction FUNCTION_DELETE_MARKED_POINTS = null;
	public static GenericFunction FUNCTION_DELETE_RANGE = null;
	public static GenericFunction FUNCTION_CROP_TRACK = null;
	public static GenericFunction FUNCTION_MARK_IN_RECTANGLE = null;
	public static GenericFunction FUNCTION_DELETE_BY_DATE = null;
	public static SingleNumericParameterFunction FUNCTION_INTERPOLATE = null;
	public static GenericFunction FUNCTION_LOOKUP_SRTM = null;
	public static GenericFunction FUNCTION_NEARBY_WIKIPEDIA = null;
	public static GenericFunction FUNCTION_SEARCH_WIKIPEDIA = null;
	public static GenericFunction FUNCTION_SEARCH_OSMPOIS = null;
	public static GenericFunction FUNCTION_DOWNLOAD_OSM = null;
	public static GenericFunction FUNCTION_ADD_TIME_OFFSET  = null;
	public static GenericFunction FUNCTION_ADD_ALTITUDE_OFFSET  = null;
	public static GenericFunction FUNCTION_CONVERT_NAMES_TO_TIMES  = null;
	public static GenericFunction FUNCTION_DELETE_FIELD_VALUES  = null;
	public static GenericFunction FUNCTION_FIND_WAYPOINT = null;
	public static GenericFunction FUNCTION_TRUNCATE_POINT_COORDS = null;
	public static GenericFunction FUNCTION_DUPLICATE_POINT = null;
	public static GenericFunction FUNCTION_CONNECT_TO_POINT = null;
	public static GenericFunction FUNCTION_DISCONNECT_PHOTO = null;
	public static GenericFunction FUNCTION_REMOVE_PHOTO = null;
	public static GenericFunction FUNCTION_DISCONNECT_AUDIO = null;
	public static GenericFunction FUNCTION_CORRELATE_PHOTOS = null;
	public static GenericFunction FUNCTION_ROTATE_PHOTO_LEFT = null;
	public static GenericFunction FUNCTION_ROTATE_PHOTO_RIGHT = null;
	public static GenericFunction FUNCTION_PHOTO_POPUP = null;
	public static GenericFunction FUNCTION_IGNORE_EXIF_THUMB = null;
	public static GenericFunction FUNCTION_CHARTS = null;
	public static GenericFunction FUNCTION_3D     = null;
	public static GenericFunction FUNCTION_DISTANCES  = null;
	public static GenericFunction FUNCTION_FULL_DETAILS = null;
	public static GenericFunction FUNCTION_AUTOPLAY_TRACK = null;
	public static GenericFunction FUNCTION_ESTIMATE_TIME = null;
	public static GenericFunction FUNCTION_LEARN_ESTIMATION_PARAMS = null;
	public static GenericFunction FUNCTION_GET_WEATHER_FORECAST = null;
	public static GenericFunction FUNCTION_LOAD_AUDIO = null;
	public static GenericFunction FUNCTION_REMOVE_AUDIO = null;
	public static GenericFunction FUNCTION_CORRELATE_AUDIOS = null;
	public static GenericFunction FUNCTION_PLAY_AUDIO = null;
	public static GenericFunction FUNCTION_STOP_AUDIO = null;
	public static GenericFunction FUNCTION_SET_DISPLAY_SETTINGS = null;
	public static GenericFunction FUNCTION_SET_WAYPOINT_DISPLAY = null;
	public static GenericFunction FUNCTION_SET_MAP_BG = null;
	public static GenericFunction FUNCTION_SET_DISK_CACHE = null;
	public static GenericFunction FUNCTION_SET_PATHS  = null;
	public static GenericFunction FUNCTION_SET_COLOURS = null;
	public static GenericFunction FUNCTION_SET_LANGUAGE = null;
	public static SingleNumericParameterFunction FUNCTION_SET_ALTITUDE_TOLERANCE = null;
	public static GenericFunction FUNCTION_SET_TIMEZONE = null;
	public static GenericFunction FUNCTION_HELP   = null;
	public static GenericFunction FUNCTION_SHOW_KEYS = null;
	public static GenericFunction FUNCTION_ABOUT  = null;
	public static GenericFunction FUNCTION_CHECK_VERSION  = null;


	/**
	 * Initialise library of functions
	 * @param inApp App object to give to functions
	 */
	public static void initialise(App inApp)
	{
		FUNCTION_GPXEXPORT = new GpxExporter(inApp);
		FUNCTION_KMLEXPORT = new KmlExporter(inApp);
		FUNCTION_POVEXPORT = new PovExporter(inApp);
		FUNCTION_IMAGEEXPORT = new ImageExporter(inApp);
		FUNCTION_GPSLOAD   = new BabelLoadFromGps(inApp);
		FUNCTION_GPSSAVE   = new GpsSaver(inApp);
		FUNCTION_IMPORTBABEL = new BabelLoadFromFile(inApp);
		FUNCTION_SAVECONFIG = new SaveConfig(inApp);
		FUNCTION_EDIT_WAYPOINT_NAME = new PointNameEditor(inApp);
		FUNCTION_PROJECT_POINT = new ProjectPoint(inApp);
		FUNCTION_PROJECT_CIRCLE = new ProjectCircle(inApp);
		FUNCTION_REARRANGE_WAYPOINTS = new RearrangeWaypointsFunction(inApp);
		FUNCTION_SELECT_SEGMENT = new SelectSegmentFunction(inApp);
		FUNCTION_SPLIT_SEGMENTS = new SplitSegmentsFunction(inApp);
		FUNCTION_SEW_SEGMENTS = new SewTrackSegmentsFunction(inApp);
		FUNCTION_CREATE_MARKER_WAYPOINTS = new CreateMarkerWaypointsFunction(inApp);
		FUNCTION_REARRANGE_PHOTOS = new RearrangePhotosFunction(inApp);
		FUNCTION_COMPRESS = new CompressTrackFunction(inApp);
		FUNCTION_MARK_LIFTS = new MarkLiftsFunction(inApp);
		FUNCTION_DELETE_MARKED_POINTS = new DeleteMarkedPointsFunction(inApp);
		FUNCTION_DELETE_RANGE = new DeleteSelectedRangeFunction(inApp);
		FUNCTION_CROP_TRACK = new CropToSelection(inApp);
		FUNCTION_MARK_IN_RECTANGLE = new MarkPointsInRectangleFunction(inApp);
		FUNCTION_DELETE_BY_DATE = new DeleteByDateFunction(inApp);
		FUNCTION_INTERPOLATE = new InterpolateFunction(inApp);
		FUNCTION_LOOKUP_SRTM = new LookupSrtmFunction(inApp);
		FUNCTION_NEARBY_WIKIPEDIA = new GetWikipediaFunction(inApp);
		FUNCTION_SEARCH_WIKIPEDIA = new SearchWikipediaNames(inApp);
		FUNCTION_SEARCH_OSMPOIS = new SearchOsmPoisFunction(inApp);
		FUNCTION_DOWNLOAD_OSM = new DownloadOsmFunction(inApp);
		FUNCTION_ADD_TIME_OFFSET = new AddTimeOffset(inApp);
		FUNCTION_ADD_ALTITUDE_OFFSET = new AddAltitudeOffset(inApp);
		FUNCTION_CONVERT_NAMES_TO_TIMES = new ConvertNamesToTimes(inApp);
		FUNCTION_DELETE_FIELD_VALUES = new DeleteFieldValues(inApp);
		FUNCTION_FIND_WAYPOINT = new FindWaypoint(inApp);
		FUNCTION_TRUNCATE_POINT_COORDS = new TruncatePointCoords(inApp);
		FUNCTION_DUPLICATE_POINT = new DuplicatePoint(inApp);
		FUNCTION_CONNECT_TO_POINT = new ConnectToPointFunction(inApp);
		FUNCTION_DISCONNECT_PHOTO = new DisconnectPhotoFunction(inApp);
		FUNCTION_REMOVE_PHOTO = new RemovePhotoFunction(inApp);
		FUNCTION_CORRELATE_PHOTOS = new PhotoCorrelator(inApp);
		FUNCTION_ROTATE_PHOTO_LEFT = new RotatePhoto(inApp, false);
		FUNCTION_ROTATE_PHOTO_RIGHT = new RotatePhoto(inApp, true);
		FUNCTION_PHOTO_POPUP = new PhotoPopupFunction(inApp);
		FUNCTION_IGNORE_EXIF_THUMB = new IgnoreExifThumb(inApp);
		FUNCTION_CHARTS = new Charter(inApp);
		FUNCTION_3D     = new ShowThreeDFunction(inApp);
		FUNCTION_DISTANCES = new DistanceFunction(inApp);
		FUNCTION_FULL_DETAILS = new ShowFullDetails(inApp);
		FUNCTION_AUTOPLAY_TRACK = new AutoplayFunction(inApp);
		FUNCTION_ESTIMATE_TIME = new EstimateTime(inApp);
		FUNCTION_LEARN_ESTIMATION_PARAMS = new LearnParameters(inApp);
		FUNCTION_GET_WEATHER_FORECAST = new GetWeatherForecastFunction(inApp);
		FUNCTION_LOAD_AUDIO = new AudioLoader(inApp);
		FUNCTION_REMOVE_AUDIO = new RemoveAudioFunction(inApp);
		FUNCTION_CORRELATE_AUDIOS = new AudioCorrelator(inApp);
		FUNCTION_PLAY_AUDIO = new PlayAudioFunction(inApp);
		FUNCTION_STOP_AUDIO = new StopAudioFunction(inApp);
		FUNCTION_DISCONNECT_AUDIO = new DisconnectAudioFunction(inApp);
		FUNCTION_SET_DISPLAY_SETTINGS = new SetDisplaySettings(inApp);
		FUNCTION_SET_WAYPOINT_DISPLAY = new SetWaypointSettings(inApp);
		FUNCTION_SET_MAP_BG = new SetMapBgFunction(inApp);
		FUNCTION_SET_DISK_CACHE = new DiskCacheConfig(inApp);
		FUNCTION_SET_PATHS = new SetPathsFunction(inApp);
		FUNCTION_SET_COLOURS = new SetColours(inApp);
		FUNCTION_SET_LANGUAGE = new SetLanguage(inApp);
		FUNCTION_SET_ALTITUDE_TOLERANCE = new SetAltitudeTolerance(inApp);
		FUNCTION_SET_TIMEZONE = new SelectTimezoneFunction(inApp);
		FUNCTION_HELP   = new HelpScreen(inApp);
		FUNCTION_SHOW_KEYS = new ShowKeysScreen(inApp);
		FUNCTION_ABOUT  = new AboutScreen(inApp);
		FUNCTION_CHECK_VERSION= new CheckVersionScreen(inApp);
	}
}
