/**
 * @license Copyright (c) 2003-2020, CKSource - Frederico Knabben. All rights
 *          reserved. For licensing, see
 *          https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here.
	// For complete reference see:
	// https://ckeditor.com/docs/ckeditor4/latest/api/CKEDITOR_config.html

	config.toolbarGroups = [
//		{ name: 'various', items: ['ExportPdf', '-', 'Undo', 'Redo'] }
		{ name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
		{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker', 'editing' ] },
		{ name: 'links', groups: [ 'links' ] },
		{ name: 'insert', groups: [ 'insert' ] },
		{ name: 'forms', groups: [ 'forms' ] },
		{ name: 'tools', groups: [ 'tools' ] },
		{ name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
		{ name: 'others', groups: [ 'others' ] },
		'/',
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi', 'paragraph' ] },
		{ name: 'styles', groups: [ 'styles' ] },
		{ name: 'colors', groups: [ 'colors' ] },
		{ name: 'about', groups: [ 'about' ] }
//		{ name : 'new_group', items: ['jsplus_image_editor', 'jsplus_edit_tag'] }
	];

	config.removeButtons = 'Underline,Subscript,Superscript,About';


	
	config.autoGrow_onStartup = true;
	config.autoGrow_minHeight = 250;
	config.autoGrow_maxHeight = 600;
	config.removePlugins = 'resize';
//	config.extraPlugins = 'some_other_plugin,one_more_plugin,jsplus_image_editor';
};
