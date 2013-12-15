/*
 * Copyright 2013 Toshiyuki Takahashi
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimer.
 *
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.github.tototoshi.slick

import scala.slick.driver._

object JodaLocalDateSupportDelegate extends JodaLocalDateMapper with JdbcDriver
object JodaDateTimeSupportDelegate extends JodaDateTimeMapper with JdbcDriver
object JodaLocalDateTimeSupportDelegate extends JodaLocalDateTimeMapper with JdbcDriver
object JodaLocalTimeSupportDelegate extends JodaLocalTimeMapper with JdbcDriver

trait JodaLocalDateSupport {
  implicit val localDateTypeMapper = JodaLocalDateSupportDelegate.TypeMapper
  implicit val getLocalDateResult = JodaLocalDateSupportDelegate.JodaGetResult.getResult
  implicit val getLocalDateOptionResult = JodaLocalDateSupportDelegate.JodaGetResult.getOptionResult
  implicit val setLocalDateParameter = JodaLocalDateSupportDelegate.JodaSetParameter.setJodaParameter
  implicit val setLocalDateOptionParameter = JodaLocalDateSupportDelegate.JodaSetParameter.setJodaOptionParameter
}

trait JodaDateTimeSupport {
  implicit val datetimeTypeMapper = JodaDateTimeSupportDelegate.TypeMapper
  implicit val getDatetimeResult = JodaDateTimeSupportDelegate.JodaGetResult.getResult
  implicit val getDatetimeOptionResult = JodaDateTimeSupportDelegate.JodaGetResult.getOptionResult
  implicit val setDatetimeParameter = JodaDateTimeSupportDelegate.JodaSetParameter.setJodaParameter
  implicit val setDatetimeOptionParameter = JodaDateTimeSupportDelegate.JodaSetParameter.setJodaOptionParameter
}

trait JodaLocalDateTimeSupport {
  implicit val localDatetimeTypeMapper = JodaLocalDateTimeSupportDelegate.TypeMapper
  implicit val getLocalDatetimeResult = JodaLocalDateTimeSupportDelegate.JodaGetResult.getResult
  implicit val getLocalDatetimeOptionResult = JodaLocalDateTimeSupportDelegate.JodaGetResult.getOptionResult
  implicit val setLocalDatetimeParameter = JodaLocalDateTimeSupportDelegate.JodaSetParameter.setJodaParameter
  implicit val setLocalDatetimeOptionParameter = JodaLocalDateTimeSupportDelegate.JodaSetParameter.setJodaOptionParameter
}

trait JodaLocalTimeSupport {
  implicit val localTimeTypeMapper = JodaLocalTimeSupportDelegate.TypeMapper
  implicit val getLocalTimeResult = JodaLocalTimeSupportDelegate.JodaGetResult.getResult
  implicit val getLocalTimeOptionResult = JodaLocalTimeSupportDelegate.JodaGetResult.getOptionResult
  implicit val setLocalTimeParameter = JodaLocalTimeSupportDelegate.JodaSetParameter.setJodaParameter
  implicit val setLocalTimeOptionParameter = JodaLocalTimeSupportDelegate.JodaSetParameter.setJodaOptionParameter
}

object JodaLocalDateSupport extends JodaLocalDateSupport
object JodaDateTimeSupport extends JodaDateTimeSupport
object JodaLocalDateTimeSupport extends JodaLocalDateTimeSupport
object JodaLocalTimeSupport extends JodaLocalTimeSupport

object JodaSupport extends JodaLocalDateSupport
  with JodaDateTimeSupport
  with JodaLocalDateTimeSupport
  with JodaLocalTimeSupport
