# frozen_string_literal: true

Given('que eu esteja na sessão {string}') do |session_name|
  Helpers::TShield.start_session(session_name.tr(' ç', '_c'))
end
