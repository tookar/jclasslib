/*
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the license, or (at your option) any later version.
*/

package org.gjt.jclasslib.structures.constants

import org.gjt.jclasslib.structures.ConstantType
import org.gjt.jclasslib.structures.InvalidByteCodeException

import java.io.DataInput
import java.io.DataOutput
import java.io.IOException

/**
 * Describes a CONSTANT_Fieldref_info constant pool data structure.

 * @author [Ingo Kegel](mailto:jclasslib@ej-technologies.com)
 */
class ConstantFieldrefInfo : ConstantReference() {

    override val constantType: ConstantType
        get() = ConstantType.CONSTANT_FIELDREF

    @Throws(InvalidByteCodeException::class, IOException::class)
    override fun read(input: DataInput) {
        super.read(input)
        if (isDebug) debug("read")
    }

    @Throws(InvalidByteCodeException::class, IOException::class)
    override fun write(output: DataOutput) {
        output.writeByte(ConstantType.CONSTANT_FIELDREF.tag)
        super.write(output)
        if (isDebug) debug("wrote")
    }

    override fun debug(message: String) {
        super.debug("$message $constantType with class_index $classIndex and name_and_type_index $nameAndTypeIndex")
    }

}
