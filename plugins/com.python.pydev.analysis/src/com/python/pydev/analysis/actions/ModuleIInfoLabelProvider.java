package com.python.pydev.analysis.actions;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.python.pydev.core.structure.FastStringBuffer;
import org.python.pydev.ui.UIConstants;

import com.python.pydev.analysis.additionalinfo.IInfo;

/**
 * Provides the labels and images for the bottom panel
 *
 * @author Fabio
 */
public final class ModuleIInfoLabelProvider extends LabelProvider {
    
    @Override
    public String getText(Object element) {
        if(element instanceof AdditionalInfoAndIInfo){
            element = ((AdditionalInfoAndIInfo)element).info;
        }
        IInfo info = (IInfo) element;
        String path = info.getPath();
        int pathLen;
        if(path != null && (pathLen = path.length()) > 0){
            FastStringBuffer buf = new FastStringBuffer(info.getDeclaringModuleName(), pathLen+5);
            buf.append("/");
            buf.append(path);
            return buf.toString();
        }
        return info.getDeclaringModuleName();
    }

    @Override
    public Image getImage(Object element) {
        return org.python.pydev.plugin.PydevPlugin.getImageCache().get(UIConstants.COMPLETION_PACKAGE_ICON);
    }
}